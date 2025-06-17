package tech.inovasoft.inevolving.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepositoryJPA;
import tech.inovasoft.inevolving.api.service.TokenService;

import java.util.Optional;

@Component
public class SecurityWebFluxFilter implements WebFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String token = recoverToken(exchange);

        if (token == null) {
            return chain.filter(exchange);
        }

        return Mono.fromCallable(() -> {
                    var idUser = tokenService.validateToken(token);
                    return userRepositoryJPA.findById(idUser); // Optional<UserDetails>
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(user -> {
                    var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    return new SecurityContextImpl(auth);
                })
                .flatMap(ctx ->
                        chain.filter(exchange)
                                .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(ctx)))
                )
                .switchIfEmpty(chain.filter(exchange));
    }

    private String recoverToken(ServerWebExchange exchange) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
