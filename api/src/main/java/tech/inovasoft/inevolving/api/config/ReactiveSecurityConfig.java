package tech.inovasoft.inevolving.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepositoryJPA;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;

@Configuration
public class ReactiveSecurityConfig {

    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager(UserRepositoryJPA userRepository, PasswordEncoder passwordEncoder) {
        return authentication -> Mono.fromCallable(() -> {
            String email = authentication.getName();
            String password = authentication.getCredentials().toString();

            UserDetails user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new BadCredentialsException("User not found"));

            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new BadCredentialsException("Invalid credentials");
            }

            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }).cast(Authentication.class)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
