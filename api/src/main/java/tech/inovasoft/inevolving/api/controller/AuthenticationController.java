package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import tech.inovasoft.inevolving.api.domain.exception.EmailNotVerifiedException;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.domain.model.UserRole;
import tech.inovasoft.inevolving.api.repository.interfaces.UserRepositoryJPA;
import tech.inovasoft.inevolving.api.service.EmailService;
import tech.inovasoft.inevolving.api.service.FinanceService;
import tech.inovasoft.inevolving.api.service.MotivationService;
import tech.inovasoft.inevolving.api.service.TokenService;
import tech.inovasoft.inevolving.api.service.client.email_service.dto.EmailRequest;
import tech.inovasoft.inevolving.api.service.client.finance_service.dto.FinancePlanning;
import tech.inovasoft.inevolving.api.service.client.motivation_service.dto.ResponseVisionBord;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

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

    @Autowired
    private MotivationService motivationService;
    @Autowired
    private FinanceService financeService;
    @Autowired
    private EmailService emailService;

    @Operation(
            summary = "End-point de Login",
            description = "Realiza o login do usuário e retorna seu token de acesso e sua imagem de vision bord."
    )
    @PostMapping("/login")
    public Mono<ResponseEntity<ResponseLoginDTO>> login(@RequestBody @Valid RequestAuthenticationDTO data) {
        var authToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        return authenticationManager.authenticate(authToken)
                .map(auth -> {
                    User user = (User) auth.getPrincipal();
                    String token = tokenService.generateToken(user);
                    if (user.isEmailVerified()) {
                        try {
                            var response = motivationService.generateVisionBordByUserId(user.getId());
                            return ResponseEntity.ok(new ResponseLoginDTO(token, response.urlVisionBord()));
                        } catch (Exception e){
                            return ResponseEntity.ok(new ResponseLoginDTO(token, "No dreams were found"));
                        }
                    } else {
                        throw new EmailNotVerifiedException("Confirme seu email, para fazer login.");
                    }
                });
    }

    @Operation(
            summary = "End-point para Registar um novo usuário.",
            description = "Realiza o registro de um novo usuário e envia um email para o usuário confirmar seu e-mail cadastrado."
    )
    @PostMapping("/register")
    public Mono<ResponseEntity<ResponseMessageDTO>> register(@RequestBody @Valid RequestAuthenticationDTO data) {
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
                        UUID idUser = userRepository.save(newUser).getId();
                        financeService.addPlanningWhenRegistering(idUser);
                        emailService.sendEmail(new EmailRequest(
                                newUser.getEmail(),
                                "Bem-vindo ao InEvolving, confirme seu-email.",
                                "Confirme seu email clicando no link abaixo: \n" +
                                        "http://localhost:8090/api/user/confirm/email/" + idUser
                        ));
                        return ResponseEntity.ok(new ResponseMessageDTO("Usuário registrado com sucesso!"));
                    }).subscribeOn(Schedulers.boundedElastic());
                });
    }
}