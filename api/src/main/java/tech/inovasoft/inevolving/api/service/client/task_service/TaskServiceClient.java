package tech.inovasoft.inevolving.api.service.client.task_service;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import tech.inovasoft.inevolving.api.service.client.email_service.dto.EmailRequest;
import tech.inovasoft.inevolving.api.service.client.task_service.dto.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@FeignClient(name = "task-service", url = "${inevolving.uri.ms.task}")
public interface TaskServiceClient {

    @PostMapping
    ResponseEntity<ResponseTaskDTO> addTask(
            @RequestBody RequestTaskDTO taskDTO
    );

    @PostMapping("/repeat/{idUser}/{idTask}/{startDate}/{endDate}")
    ResponseEntity<ResponseRepeatTaskDTO> repeatTask(
            @PathVariable UUID idUser,
            @PathVariable UUID idTask,
            @PathVariable Date startDate,
            @PathVariable Date endDate,
            @RequestBody DaysOfTheWeekDTO daysOfTheWeekDTO
    );

    @PutMapping("/{idUser}/{idTask}")
    ResponseEntity<ResponseTaskDTO> updateTask(
            @PathVariable UUID idUser,
            @PathVariable UUID idTask,
            @RequestBody RequestUpdateTaskDTO updateTaskDTO
    );

    @PutMapping("/repeat/{idUser}/{idTask}/{endDate}")
    ResponseEntity<ResponseUpdateRepeatTaskDTO> updateTasksAndTheirFutureRepetitions(
            @PathVariable UUID idUser,
            @PathVariable UUID idTask,
            @PathVariable Date endDate,
            @RequestBody RequestUpdateRepeatTaskDTO updateTaskDTO
    );

    @PutMapping("/status/todo/{idUser}/{idTask}")
    ResponseEntity<ResponseTaskDTO> updateTaskStatusToDo(
            @PathVariable UUID idUser,
            @PathVariable UUID idTask
    );

    @PutMapping("/status/progress/{idUser}/{idTask}")
    ResponseEntity<ResponseTaskDTO> updateTaskStatusInProgress(
            @PathVariable UUID idUser,
            @PathVariable UUID idTask
    );

    @PutMapping("/status/done/{idUser}/{idTask}")
    ResponseEntity<ResponseTaskDTO> updateTaskStatusDone(
            @PathVariable UUID idUser,
            @PathVariable UUID idTask
    );

    @PutMapping("/status/late/{idUser}/{idTask}")
    ResponseEntity<ResponseTaskDTO> updateTaskStatusLate(
            @PathVariable UUID idUser,
            @PathVariable UUID idTask
    );

    @PutMapping("/status/canceled")
    ResponseEntity<ResponseTaskDTO> updateTaskStatusCanceled(
            @RequestBody RequestCanceledDTO dto
    );

    @DeleteMapping("/{idUser}/{idTask}")
    ResponseEntity<ResponseMessageDTO> deleteTask(
            @PathVariable UUID idUser,
            @PathVariable UUID idTask
    );

    @DeleteMapping("/repeat/{idUser}/{idTask}/{date}")
    ResponseEntity<ResponseDeleteTasksDTO> deleteTasksAndTheirFutureRepetitions(
            @PathVariable UUID idUser,
            @PathVariable UUID idTask,
            @PathVariable Date date
    );

    @DeleteMapping("/lock/{completionDate}/{idUser}/{idObjective}")
    ResponseEntity<ResponseMessageDTO> lockTaskByObjective(
            @PathVariable Date completionDate,
            @PathVariable UUID idUser,
            @PathVariable UUID idObjective
    );

    @GetMapping("/{idUser}/{startDate}/{endDate}")
    ResponseEntity<List<Task>> getTasksInDateRange(
            @PathVariable UUID idUser,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    );

    @GetMapping("/{idUser}/{idObjective}/{startDate}/{endDate}")
    ResponseEntity<List<Task>> getTasksInDateRangeByObjectiveId(
            @PathVariable UUID idUser,
            @PathVariable UUID idObjective,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    );

    @GetMapping("/{idUser}/{idObjective}")
    ResponseEntity<List<Task>> getTasksByObjectiveId(
            @PathVariable UUID idUser,
            @PathVariable UUID idObjective
    );

    @GetMapping("/{idUser}/{date}")
    ResponseEntity<List<Task>> getTasksInDate(
            @PathVariable UUID idUser,
            @PathVariable Date date
    );

    @GetMapping("/late/{idUser}")
    ResponseEntity<List<Task>> getTasksLate(
            @PathVariable UUID idUser
    );

    @GetMapping("/status/todo/{idUser}/{startDate}/{endDate}")
    ResponseEntity<List<Task>> getTasksToDoInDateRange(
            @PathVariable UUID idUser,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    );

    @GetMapping("/status/todo/{idUser}/{date}")
    ResponseEntity<List<Task>> getTasksToDoInDate(
            @PathVariable UUID idUser,
            @PathVariable Date date
    );

    @GetMapping("/status/progress/{idUser}/{startDate}/{endDate}")
    ResponseEntity<List<Task>> getTasksInProgressInDateRange(
            @PathVariable UUID idUser,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    );

    @GetMapping("/status/progress/{idUser}/{date}")
    ResponseEntity<List<Task>> getTasksInProgressInDate(
            @PathVariable UUID idUser,
            @PathVariable Date date
    );

    @GetMapping("/status/done/{idUser}/{startDate}/{endDate}")
    ResponseEntity<List<Task>> getTasksDoneInDateRange(
            @PathVariable UUID idUser,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    );

    @GetMapping("/status/done/{idUser}/{date}")
    ResponseEntity<List<Task>> getTasksDoneInDate(
            @PathVariable UUID idUser,
            @PathVariable Date date
    );

    @GetMapping("/status/canceled/{idUser}/{startDate}/{endDate}")
    ResponseEntity<List<Task>> getTasksCanceledInDateRange(
            @PathVariable UUID idUser,
            @PathVariable Date startDate,
            @PathVariable Date endDate
    );

    @GetMapping("/status/canceled/{idUser}/{date}")
    ResponseEntity<List<Task>> getTasksCanceledInDate(
            @PathVariable UUID idUser,
            @PathVariable Date date
    );

}
