package tech.inovasoft.inevolving.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.dto.request.CanceledRequestDTO;
import tech.inovasoft.inevolving.api.domain.dto.request.TaskRequestDTO;
import tech.inovasoft.inevolving.api.domain.model.User;
import tech.inovasoft.inevolving.api.service.TasksService;
import tech.inovasoft.inevolving.api.service.client.task_service.dto.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Tag(name = "Tarefas | Tasks")
@RestController
@RequestMapping("/auth/api/tasks")
@SecurityRequirement(name = "bearerAuth")
public class TaskController {

    @Autowired
    private TasksService tasksService;

    @Operation(description = "End-point para adicionar uma nova tarefa.")
    @PostMapping
    Mono<ResponseEntity<ResponseTaskDTO>> addTask(
            Authentication authentication,
            @RequestBody Mono<TaskRequestDTO> monoDto
    ) {
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTaskDTO response = tasksService.addTask(idUser, dto);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para repetir uma nova tarefa.")
    @PostMapping("/repeat/{idTask}/{startDate}/{endDate}")
    Mono<ResponseEntity<ResponseRepeatTaskDTO>> repeatTask(
            Authentication authentication,
            @PathVariable UUID idTask,
            @PathVariable Date startDate,
            @PathVariable Date endDate,
            @RequestBody Mono<DaysOfTheWeekDTO> monoDto
    ) {
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseRepeatTaskDTO response = tasksService.repeatTask(idUser, dto, idTask,startDate, endDate);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para atualizar uma tarefa.")
    @PutMapping("/{idTask}")
    Mono<ResponseEntity<ResponseTaskDTO>> updateTask(
            Authentication authentication,
            @PathVariable UUID idTask,
            @RequestBody Mono<RequestUpdateTaskDTO> monoDto
    ) {
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTaskDTO response = tasksService.updateTask(idUser, dto, idTask);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para atualizar uma tarefa e suas futuras repetições.")
    @PutMapping("/repeat/{idTask}/{endDate}")
    Mono<ResponseEntity<ResponseUpdateRepeatTaskDTO>> updateTasksAndTheirFutureRepetitions(
            Authentication authentication,
            @PathVariable UUID idTask,
            @PathVariable Date endDate,
            @RequestBody Mono<RequestUpdateRepeatTaskDTO> monoDto
    ) {
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseUpdateRepeatTaskDTO response =
                    tasksService.updateTasksAndTheirFutureRepetitions(idUser, dto, idTask, endDate);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para atualizar o status de uma tarefa para pendente.")
    @PatchMapping("/status/todo/{idTask}")
    Mono<ResponseEntity<ResponseTaskDTO>> updateTaskStatusToDo(
            Authentication authentication,
            @PathVariable UUID idTask
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTaskDTO response = tasksService
                    .updateTaskStatusToDo(idUser, idTask);
        return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para atualizar o status de uma tarefa para em andamento.")
    @PatchMapping("/status/progress/{idTask}")
    Mono<ResponseEntity<ResponseTaskDTO>> updateTaskStatusInProgress(
            Authentication authentication,
            @PathVariable UUID idTask
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTaskDTO response = tasksService
                    .updateTaskStatusInProgress(idUser, idTask);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para atualizar o status de uma tarefa para concluída.")
    @PatchMapping("/status/done/{idTask}")
    Mono<ResponseEntity<ResponseTaskDTO>> updateTaskStatusDone(
            Authentication authentication,
            @PathVariable UUID idTask
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTaskDTO response = tasksService
                    .updateTaskStatusDone(idUser, idTask);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para atualizar o status de uma tarefa para atrasada.")
    @PatchMapping("/status/late/{idTask}")
    Mono<ResponseEntity<ResponseTaskDTO>> updateTaskStatusLate(
            Authentication authentication,
            @PathVariable UUID idTask
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTaskDTO response = tasksService
                    .updateTaskStatusLate(idUser, idTask);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para atualizar o status de uma tarefa para cancelada.")
    @PatchMapping("/status/canceled")
    Mono<ResponseEntity<ResponseTaskDTO>> updateTaskStatusCanceled(
            Authentication authentication,
            @RequestBody Mono<CanceledRequestDTO> monoDto
    ) {
        return monoDto.map(dto -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseTaskDTO response =
                    tasksService.updateTaskStatusCanceled(idUser, dto);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para deletar uma tarefa.")
    @DeleteMapping("/{idTask}")
    Mono<ResponseEntity<ResponseMessageDTO>> deleteTask(
            Authentication authentication,
            @PathVariable UUID idTask
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseMessageDTO response = tasksService
                    .deleteTask(idUser, idTask);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para deletar uma tarefa e suas futuras repetições.")
    @DeleteMapping("/repeat/{idTask}/{date}")
    Mono<ResponseEntity<ResponseDeleteTasksDTO>> deleteTasksAndTheirFutureRepetitions(
            Authentication authentication,
            @PathVariable UUID idTask,
            @PathVariable Date date
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseDeleteTasksDTO response = tasksService
                    .deleteTasksAndTheirFutureRepetitions(idUser, idTask, date);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point responsável por bloquear as tarefa antigas de um objetivo concluido para manter o histórico.")
    @DeleteMapping("/lock/{completionDate}/{idObjective}")
    Mono<ResponseEntity<ResponseMessageDTO>> lockTaskByObjective(
            Authentication authentication,
            @PathVariable Date completionDate,
            @PathVariable UUID idObjective
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            ResponseMessageDTO response = tasksService
                    .lockTaskByObjective(idUser, completionDate, idObjective);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas em um intervalo de datas.")
    @GetMapping("/{startDate}/{endDate}")
    Mono<ResponseEntity<List<Task>>> getTasksInDateRange(
            Authentication authentication,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksInDateRange(idUser, startDate, endDate);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas em um intervalo de datas por objetivo.")
    @GetMapping("/{idObjective}/{startDate}/{endDate}")
    Mono<ResponseEntity<List<Task>>> getTasksInDateRangeByObjectiveId(
            Authentication authentication,
            @PathVariable UUID idObjective,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksInDateRangeByObjectiveId(idUser, idObjective, startDate, endDate);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas por objetivo.")
    @GetMapping("/objective/{idObjective}")
    Mono<ResponseEntity<List<Task>>> getTasksByObjectiveId(
            Authentication authentication,
            @PathVariable UUID idObjective
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksByObjectiveId(idUser, idObjective);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas em uma data.")
    @GetMapping("/{date}")
    Mono<ResponseEntity<List<Task>>> getTasksInDate(
            Authentication authentication,
            @PathVariable Date date
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksInDate(idUser, date);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas atrasadas.")
    @GetMapping("/late")
    Mono<ResponseEntity<List<Task>>> getTasksLate(
            Authentication authentication
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksLate(idUser);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas pendentes em um intervalo de datas.")
    @GetMapping("/status/todo/{startDate}/{endDate}")
    Mono<ResponseEntity<List<Task>>> getTasksToDoInDateRange(
            Authentication authentication,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksToDoInDateRange(idUser, startDate, endDate);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas pendentes em uma data.")
    @GetMapping("/status/todo/{date}")
    Mono<ResponseEntity<List<Task>>> getTasksToDoInDate(
            Authentication authentication,
            @PathVariable Date date
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksToDoInDate(idUser, date);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas em andamento em um intervalo de datas.")
    @GetMapping("/status/progress/{startDate}/{endDate}")
    Mono<ResponseEntity<List<Task>>> getTasksInProgressInDateRange(
            Authentication authentication,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksInProgressInDateRange(idUser, startDate, endDate);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas em andamento em uma data.")
    @GetMapping("/status/progress/{date}")
    Mono<ResponseEntity<List<Task>>> getTasksInProgressInDate(
            Authentication authentication,
            @PathVariable Date date
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksInProgressInDate(idUser, date);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas concluídas em um intervalo de datas.")
    @GetMapping("/status/done/{startDate}/{endDate}")
    Mono<ResponseEntity<List<Task>>> getTasksDoneInDateRange(
            Authentication authentication,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksDoneInDateRange(idUser, startDate, endDate);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas concluídas em uma data.")
    @GetMapping("/status/done/{date}")
    Mono<ResponseEntity<List<Task>>> getTasksDoneInDate(
            Authentication authentication,
            @PathVariable Date date
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksDoneInDate(idUser, date);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas canceladas em um intervalo de datas.")
    @GetMapping("/status/canceled/{startDate}/{endDate}")
    Mono<ResponseEntity<List<Task>>> getTasksCanceledInDateRange(
            Authentication authentication,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksCanceledInDateRange(idUser, startDate, endDate);
            return ResponseEntity.ok(response);
        });
    }

    @Operation(description = "End-point para buscar as tarefas canceladas em uma data.")
    @GetMapping("/status/canceled/{date}")
    Mono<ResponseEntity<List<Task>>> getTasksCanceledInDate(
            Authentication authentication,
            @PathVariable Date date
    ) {
        return Mono.fromCallable(() -> {
            var user = (User) authentication.getPrincipal();
            var idUser = user.getId();
            List<Task> response = tasksService
                    .getTasksCanceledInDate(idUser, date);
            return ResponseEntity.ok(response);
        });
    }

}
