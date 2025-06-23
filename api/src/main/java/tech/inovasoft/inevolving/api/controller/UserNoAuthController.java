package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.dto.response.ResponseMessageDTO;
import tech.inovasoft.inevolving.api.service.UserService;

import java.util.UUID;

@Tag(name = "Usuário | User")
@RestController
@RequestMapping("/api/user")
@SecurityRequirement(name = "bearerAuth")
public class UserNoAuthController {

    @Autowired
    private UserService userService;

    @Operation(description = "End-point publico para confirmar o email do usuário.")
    @GetMapping("/confirm/email/{idUser}")
    Mono<ResponseEntity<ResponseMessageDTO>> confirmEmail(@PathVariable("idUser") UUID idUser) {
        return Mono.fromCallable(() -> {
            ResponseMessageDTO responseMessageDTO = userService.confirmEmail(idUser);
            return ResponseEntity.ok(responseMessageDTO);
        });
    }

}
