package tech.inovasoft.inevolving.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import reactor.core.publisher.Mono;
import org.springframework.security.config.web.server.ServerHttpSecurity;

@Slf4j
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http,
                                                      SecurityWebFluxFilter securityWebFluxFilter) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance()) // Stateless
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/auth/**").authenticated()
                        .anyExchange().permitAll())
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(unauthorizedEntryPoint())
                        .accessDeniedHandler(accessDeniedHandler()))
                .addFilterAt(securityWebFluxFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }

    private ServerAuthenticationEntryPoint unauthorizedEntryPoint() {
        return (exchange, ex) -> {
            log.error("Authentication error: {}", ex.getMessage());
            return Mono.fromRunnable(() -> exchange.getResponse()
                    .setStatusCode(HttpStatus.UNAUTHORIZED));
        };
    }

    private ServerAccessDeniedHandler accessDeniedHandler() {
        return (exchange, ex) -> {
            log.error("Access denied: {}", ex.getMessage());
            return Mono.fromRunnable(() -> exchange.getResponse()
                    .setStatusCode(HttpStatus.FORBIDDEN));
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}