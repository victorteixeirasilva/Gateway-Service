package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.dto.request.CreateObjectiveDTO;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.service.ObjectivesService;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.Objective;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.ResponseMessageDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Tag(name = "Objetivos | Objectives")
@RestController
@RequestMapping("/auth/api/objectives")
@SecurityRequirement(name = "bearerAuth")
public class ObjectivesController {
    
    @Autowired
    private ObjectivesService objectivesService;

    @Operation(description = "End-point para adicionar um novo objetivo.")
    @PostMapping
    Mono<ResponseEntity<Objective>> add(
            Authentication authentication,
            @RequestBody Mono<CreateObjectiveDTO> monoDto
    ) {
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Objective objective = objectivesService.add(idUser, dto);
            return ResponseEntity.ok(objective);
        });
    }

    @Operation(description = "End-point para atualizar um objetivo.")
    @PutMapping("/{idObjective}")
    Mono<ResponseEntity<Objective>> update(
            Authentication authentication,
            @PathVariable UUID idObjective,
            @RequestBody Mono<CreateObjectiveDTO> monoDto
    ) {
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Objective objective = objectivesService.update(idObjective, idUser, dto);
            return ResponseEntity.ok(objective);
        });
    }

    @Operation(description = "End-point para marcar objetivo, como concluido.")
    @PatchMapping("/{idObjective}/{conclusionDate}")
    Mono<ResponseEntity<ResponseMessageDTO>> completeObjective(
            Authentication authentication,
            @PathVariable UUID idObjective,
            @PathVariable LocalDate conclusionDate
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseMessageDTO responseMessageDTO = objectivesService
                    .completeObjective(idUser, idObjective, conclusionDate);
            return ResponseEntity.ok(responseMessageDTO);
        });
    }

    @Operation(description = "End-point para obter um objetivo.")
    @GetMapping("/{idObjective}")
    Mono<ResponseEntity<Objective>> getObjectiveById(
            Authentication authentication,
            @PathVariable UUID idObjective
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            Objective objective = objectivesService
                    .getObjectiveById(idUser, idObjective);
            return ResponseEntity.ok(objective);
        });
    }

    @Operation(description = "End-point para obter todos os objetivos do usuário.")
    @GetMapping("/user")
    Mono<ResponseEntity<List<Objective>>>  getObjectivesByIdUser(
            Authentication authentication
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Objective> objectivesList = objectivesService
                    .getObjectivesByIdUser(idUser);
            return ResponseEntity.ok(objectivesList);
        });
    }

    @Operation(description = "End-point para obter todos os objetivos pendentes do usuário.")
    @GetMapping("/status/todo/user")
    Mono<ResponseEntity<List<Objective>>> getObjectivesByIdUserToDo(
            Authentication authentication
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Objective> objectivesList = objectivesService
                    .getObjectivesByIdUserToDo(idUser);
            return ResponseEntity.ok(objectivesList);
        });
    }

    @Operation(description = "End-point para obter todos os objetivos concluidos do usuário.")
    @GetMapping("/status/done/user")
    Mono<ResponseEntity<List<Objective>>> getObjectivesByIdUserDone(
            Authentication authentication
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Objective> objectivesList = objectivesService
                    .getObjectivesByIdUserDone(idUser);
            return ResponseEntity.ok(objectivesList);
        });
    }
    
}
