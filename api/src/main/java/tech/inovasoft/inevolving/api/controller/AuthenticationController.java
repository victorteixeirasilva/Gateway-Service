package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.inovasoft.inevolving.api.domain.dto.request.RequestAuthenticationDTO;
import tech.inovasoft.inevolving.api.domain.dto.response.ResponseLoginDTO;
import tech.inovasoft.inevolving.api.domain.dto.response.ResponseMessageDTO;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.domain.model.UserRole;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepositoryJPA;
import tech.inovasoft.inevolving.api.service.TokenService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Tag(name = "Autenticação | Authentication")
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Autowired
    private TokenService tokenService;

    @Async("asyncExecutor")
    @PostMapping("/login")
    public CompletableFuture<ResponseEntity<ResponseLoginDTO>> login(@RequestBody @Valid RequestAuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return CompletableFuture.completedFuture(ResponseEntity.ok(new ResponseLoginDTO(token)));
    }

    @Async("asyncExecutor")
    @PostMapping("/register")
    public CompletableFuture<ResponseEntity<ResponseMessageDTO>> register(@RequestBody @Valid RequestAuthenticationDTO data) {
        if (this.userRepositoryJPA.findByEmail(data.email().toLowerCase()) != null) {
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().build());
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User();
        newUser.setEmail(data.email().toLowerCase());
        newUser.setPassword(encryptedPassword);
        newUser.setLastLogin(Date.valueOf(LocalDate.now()));
        newUser.setRole(UserRole.USER);

        this.userRepositoryJPA.save(newUser);

        return CompletableFuture.completedFuture(ResponseEntity.ok(new ResponseMessageDTO("User created")));
    }

}
