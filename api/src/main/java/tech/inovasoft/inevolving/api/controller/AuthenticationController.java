package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import tech.inovasoft.inevolving.api.domain.dto.request.RequestAuthenticationDTO;
import tech.inovasoft.inevolving.api.domain.dto.response.ResponseLoginDTO;
import tech.inovasoft.inevolving.api.domain.dto.response.ResponseMessageDTO;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.domain.model.UserRole;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepositoryJPA;
import tech.inovasoft.inevolving.api.service.TokenService;

import java.sql.Date;
import java.time.LocalDate;

@Tag(name = "Autenticação | Authentication")
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private final ReactiveAuthenticationManager authenticationManager;
    private final UserRepositoryJPA userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(
            ReactiveAuthenticationManager authenticationManager,
            UserRepositoryJPA userRepository,
            TokenService tokenService,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<ResponseLoginDTO>> login(@RequestBody @Valid RequestAuthenticationDTO data) {
        // TODO: Desenvolver validação de email
        // TODO: Consumir gerador de VisionBord assim que se logar
        var authToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        return authenticationManager.authenticate(authToken)
                .map(auth -> {
                    User user = (User) auth.getPrincipal();
                    String token = tokenService.generateToken(user);
                    return ResponseEntity.ok(new ResponseLoginDTO(token));
                });
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<ResponseMessageDTO>> register(@RequestBody @Valid RequestAuthenticationDTO data) {
        // TODO: Desenvolver chamada ao FinancePlanning assim que se registrar.
        return Mono.fromCallable(() -> userRepository.findByEmail(data.email().toLowerCase()))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(existing -> {
                    if (existing.isPresent()) {
                        return Mono.just(ResponseEntity.badRequest().body(new ResponseMessageDTO("E-mail já cadastrado")));
                    }

                    User newUser = new User();
                    newUser.setEmail(data.email().toLowerCase());
                    newUser.setPassword(passwordEncoder.encode(data.password()));
                    newUser.setLastLogin(Date.valueOf(LocalDate.now()));
                    newUser.setRole(UserRole.USER);

                    return Mono.fromCallable(() -> {
                        userRepository.save(newUser);
                        return ResponseEntity.ok(new ResponseMessageDTO("Usuário registrado com sucesso!"));
                    }).subscribeOn(Schedulers.boundedElastic());
                });
    }
}