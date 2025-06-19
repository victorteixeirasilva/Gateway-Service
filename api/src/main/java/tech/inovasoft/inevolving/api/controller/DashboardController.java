package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.service.DashboardService;
import tech.inovasoft.inevolving.api.service.client.categories_service.dto.ResponseMessageDTO;
import tech.inovasoft.inevolving.api.service.client.dashboard_service.dto.ResponseDashbordDTO;

import java.util.UUID;

@Tag(name = "Dashboard")
@RestController
@RequestMapping("/auth/api/dashboard")
@SecurityRequirement(name = "bearerAuth")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    Mono<ResponseEntity<ResponseDashbordDTO>> getDashboard(Authentication authentication){
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseDashbordDTO responseDashbordDTO =
                    dashboardService.getDashboard(idUser);
            return ResponseEntity.ok(responseDashbordDTO);
        });
    }
}
