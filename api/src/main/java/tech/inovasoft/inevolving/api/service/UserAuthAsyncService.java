package tech.inovasoft.inevolving.api.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.concurrent.CompletableFuture;

@Service
public class UserAuthAsyncService {

    @Async("asyncExecutor")
    public CompletableFuture<ResponseEntity<String>> processUserAuth(Authentication authentication) {
        Authentication contextAuth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(">>> Contexto de segurança na thread assíncrona: " + contextAuth);


        System.out.println(">>> Executando em thread: " + Thread.currentThread().getName());
        String username = authentication.getName(); // Isso pode lançar exceção se o contexto estiver vazio
        return CompletableFuture.completedFuture(
                ResponseEntity.ok("User created Auth for: " + username)
        );
    }

//    @Async("asyncExecutor")
//    public CompletableFuture<ResponseEntity<String>> processUserAuth(Authentication authentication) {
//        String username = authentication.getName();
//        return CompletableFuture.completedFuture(
//                ResponseEntity.ok("User created Auth for: " + username)
//        );
//    }
}