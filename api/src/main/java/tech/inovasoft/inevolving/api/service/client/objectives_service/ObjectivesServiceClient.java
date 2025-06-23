package tech.inovasoft.inevolving.api.service.client.objectives_service;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import tech.inovasoft.inevolving.api.service.client.email_service.dto.EmailRequest;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.Objective;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.RequestCreateObjectiveDTO;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.ResponseMessageDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@FeignClient(name = "objectives-service", url = "http://localhost:8088/ms/objectives")
public interface ObjectivesServiceClient {

    @PostMapping
    ResponseEntity<Objective> add(
            @RequestBody RequestCreateObjectiveDTO dto
    );

    @PutMapping("/{idObjective}/{idUser}")
    ResponseEntity<Objective> update(
            @PathVariable UUID idObjective,
            @PathVariable UUID idUser,
            @RequestBody RequestCreateObjectiveDTO dto
    );

    @PutMapping("/{idObjective}/{conclusionDate}/{idUser}")
    ResponseEntity<ResponseMessageDTO> completeObjective(
            @PathVariable UUID idObjective,
            @PathVariable LocalDate conclusionDate,
            @PathVariable UUID idUser
    );

    @GetMapping("/{idObjective}/{idUser}")
    ResponseEntity<Objective> getObjectiveById(
            @PathVariable UUID idObjective,
            @PathVariable UUID idUser
    );

    @GetMapping("/user/{idUser}")
    ResponseEntity<List<Objective>>  getObjectivesByIdUser(
            @PathVariable UUID idUser
    );

    @GetMapping("/status/todo/user/{idUser}")
    ResponseEntity<List<Objective>> getObjectivesByIdUserToDo(
            @PathVariable UUID idUser
    );

    @GetMapping("/status/done/user/{idUser}")
    ResponseEntity<List<Objective>> getObjectivesByIdUserDone(
            @PathVariable UUID idUser
    );

}
