package tech.inovasoft.inevolving.api.service.client.dashboard_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inovasoft.inevolving.api.service.client.dashboard_service.dto.ResponseDashbordDTO;
import tech.inovasoft.inevolving.api.service.client.motivation_service.dto.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@FeignClient(name = "dashboard-service", url = "${inevolving.uri.ms.dashboard}")
public interface DashboardServiceClient {

    @GetMapping("/{idUser}")
    ResponseEntity<ResponseDashbordDTO> getDashboard(@PathVariable UUID idUser);

}
