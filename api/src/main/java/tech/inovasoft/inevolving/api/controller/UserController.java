package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;




@Tag(name = "Usuário | User")
@RestController
@RequestMapping("/auth/api/user")
@SecurityRequirement(name = "bearerAuth")
public class UserController {


    @GetMapping
    public Mono<ResponseEntity<String>> createUserAuth(Authentication authentication) {
        return Mono.fromCallable(() -> {
            String username = authentication.getName();
            return ResponseEntity.ok("User created Auth for: " + username);
        }).subscribeOn(Schedulers.boundedElastic());
    }
}
