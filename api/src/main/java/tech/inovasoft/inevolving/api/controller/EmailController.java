package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.service.EmailService;
import tech.inovasoft.inevolving.api.service.client.categories_service.dto.Category;
import tech.inovasoft.inevolving.api.service.client.email_service.dto.EmailRequest;

@Tag(name = "Email")
@RestController
@RequestMapping("/auth/api/email")
@SecurityRequirement(name = "bearerAuth")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    Mono<ResponseEntity<String>> sendEmail(
            Authentication authentication,
            @RequestBody Mono<EmailRequest> monoRequest
    ) {
        return monoRequest.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            String response = emailService.sendEmail(dto);
            return ResponseEntity.ok(response);
        });
    }

}
