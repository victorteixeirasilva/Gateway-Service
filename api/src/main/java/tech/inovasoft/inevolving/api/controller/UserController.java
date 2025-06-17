package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.inovasoft.inevolving.api.domain.dto.response.ResponseLoginDTO;

import java.util.concurrent.CompletableFuture;

@Tag(name = "Usuário | User")
@RestController
@RequestMapping("/auth/api/user")
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @Async("asyncExecutor")
    @GetMapping
    public CompletableFuture<ResponseEntity<String>> createUserAuth() {
        return CompletableFuture.completedFuture(ResponseEntity.ok("User created Auth"));
    }
}
