package tech.inovasoft.inevolving.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.request.CanceledRequestDTO;
import tech.inovasoft.inevolving.api.domain.dto.request.TaskRequestDTO;
import tech.inovasoft.inevolving.api.domain.exception.DashboardServiceException;
import tech.inovasoft.inevolving.api.domain.exception.TasksServiceException;
import tech.inovasoft.inevolving.api.service.client.objectives_service.dto.Objective;
import tech.inovasoft.inevolving.api.service.client.task_service.TaskServiceClient;
import tech.inovasoft.inevolving.api.service.client.task_service.dto.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TasksService {

    @Autowired
    private TaskServiceClient taskServiceClient;

    public ResponseTaskDTO addTask(UUID idUser, TaskRequestDTO dto) {
        ResponseEntity<ResponseTaskDTO> response =
                taskServiceClient.addTask(new RequestTaskDTO(idUser, dto));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.addTask).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.addTask).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.addTask).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseRepeatTaskDTO repeatTask(UUID idUser, DaysOfTheWeekDTO dto, UUID idTask, Date startDate, Date endDate) {
        ResponseEntity<ResponseRepeatTaskDTO> response =
                taskServiceClient.repeatTask(idUser, idTask, startDate, endDate, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.repeatTask).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.repeatTask).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.repeatTask).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTaskDTO updateTask(UUID idUser, RequestUpdateTaskDTO dto, UUID idTask) {
        ResponseEntity<ResponseTaskDTO> response =
                taskServiceClient.updateTask(idUser, idTask, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTask).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTask).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTask).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseUpdateRepeatTaskDTO updateTasksAndTheirFutureRepetitions(UUID idUser, RequestUpdateRepeatTaskDTO dto, UUID idTask, Date endDate) {
        ResponseEntity<ResponseUpdateRepeatTaskDTO> response =
                taskServiceClient.updateTasksAndTheirFutureRepetitions(idUser, idTask, endDate, dto);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTasksAndTheirFutureRepetitions).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTasksAndTheirFutureRepetitions).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTasksAndTheirFutureRepetitions).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTaskDTO updateTaskStatusToDo(UUID idUser, UUID idTask) {
        ResponseEntity<ResponseTaskDTO> response =
                taskServiceClient.updateTaskStatusToDo(idUser, idTask);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusToDo).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusToDo).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusToDo).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTaskDTO updateTaskStatusInProgress(UUID idUser, UUID idTask) {
        ResponseEntity<ResponseTaskDTO> response =
                taskServiceClient.updateTaskStatusInProgress(idUser, idTask);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusInProgress).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusInProgress).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusInProgress).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTaskDTO updateTaskStatusDone(UUID idUser, UUID idTask) {
        ResponseEntity<ResponseTaskDTO> response =
                taskServiceClient.updateTaskStatusDone(idUser, idTask);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusDone).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusDone).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusDone).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTaskDTO updateTaskStatusLate(UUID idUser, UUID idTask) {
        ResponseEntity<ResponseTaskDTO> response =
                taskServiceClient.updateTaskStatusLate(idUser, idTask);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusLate).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusLate).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusLate).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseTaskDTO updateTaskStatusCanceled(UUID idUser, CanceledRequestDTO dto) {
        ResponseEntity<ResponseTaskDTO> response =
                taskServiceClient.updateTaskStatusCanceled(new RequestCanceledDTO(idUser, dto));

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusCanceled).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusCanceled).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.updateTaskStatusCanceled).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseMessageDTO deleteTask(UUID idUser, UUID idTask) {
        ResponseEntity<ResponseMessageDTO> response =
                taskServiceClient.deleteTask(idUser, idTask);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.deleteTask).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.deleteTask).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.deleteTask).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseDeleteTasksDTO deleteTasksAndTheirFutureRepetitions(UUID idUser, UUID idTask, Date date) {
        ResponseEntity<ResponseDeleteTasksDTO> response =
                taskServiceClient.deleteTasksAndTheirFutureRepetitions(idUser, idTask, date);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.deleteTasksAndTheirFutureRepetitions).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.deleteTasksAndTheirFutureRepetitions).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.deleteTasksAndTheirFutureRepetitions).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public ResponseMessageDTO lockTaskByObjective(UUID idUser, Date completionDate, UUID idObjective) {
        ResponseEntity<ResponseMessageDTO> response =
                taskServiceClient.lockTaskByObjective(completionDate, idUser, idObjective);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.lockTaskByObjective).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.lockTaskByObjective).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.lockTaskByObjective).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksInDateRange(UUID idUser, Date startDate, Date endDate) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksInDateRange(idUser, startDate, endDate);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInDateRange).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInDateRange).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInDateRange).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksInDateRangeByObjectiveId(UUID idUser, UUID idObjective, Date startDate, Date endDate) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksInDateRangeByObjectiveId(idUser, idObjective, startDate, endDate);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInDateRangeByObjectiveId).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInDateRangeByObjectiveId).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInDateRangeByObjectiveId).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksByObjectiveId(UUID idUser, UUID idObjective) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksByObjectiveId(idUser, idObjective);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksByObjectiveId).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksByObjectiveId).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksByObjectiveId).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksInDate(UUID idUser, Date date) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksInDate(idUser, date);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInDate).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInDate).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInDate).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksLate(UUID idUser) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksLate(idUser);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksLate).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksLate).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksLate).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksToDoInDateRange(UUID idUser, Date startDate, Date endDate) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksToDoInDateRange(idUser, startDate, endDate);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksToDoInDateRange).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksToDoInDateRange).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksToDoInDateRange).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksToDoInDate(UUID idUser, Date date) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksToDoInDate(idUser, date);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksToDoInDate).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksToDoInDate).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksToDoInDate).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksInProgressInDateRange(UUID idUser, Date startDate, Date endDate) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksInProgressInDateRange(idUser, startDate, endDate);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInProgressInDateRange).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInProgressInDateRange).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInProgressInDateRange).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksInProgressInDate(UUID idUser, Date date) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksInProgressInDate(idUser, date);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInProgressInDate).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInProgressInDate).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksInProgressInDate).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksDoneInDateRange(UUID idUser, Date startDate, Date endDate) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksDoneInDateRange(idUser, startDate, endDate);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksDoneInDateRange).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksDoneInDateRange).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksDoneInDateRange).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksDoneInDate(UUID idUser, Date date) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksDoneInDate(idUser, date);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksDoneInDate).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksDoneInDate).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksDoneInDate).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksCanceledInDateRange(UUID idUser, Date startDate, Date endDate) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksCanceledInDateRange(idUser, startDate, endDate);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksCanceledInDateRange).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksCanceledInDateRange).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksCanceledInDateRange).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }

    public List<Task> getTasksCanceledInDate(UUID idUser, Date date) {
        ResponseEntity<List<Task>> response =
                taskServiceClient.getTasksCanceledInDate(idUser, date);

        if (response.getStatusCode().isSameCodeAs(HttpStatus.INTERNAL_SERVER_ERROR)) {
            throw new TasksServiceException(
                    "Error (INTERNAL_SERVER_ERROR) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksCanceledInDate).",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.FORBIDDEN)) {
            throw new TasksServiceException(
                    "Error (FORBIDDEN) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksCanceledInDate).",
                    HttpStatus.FORBIDDEN
            );
        }

        if (response.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
            throw new TasksServiceException(
                    "Error (NOT_FOUND) in micro service (tasks-service), during operation " +
                            "(taskServiceClient.getTasksCanceledInDate).",
                    HttpStatus.NOT_FOUND
            );
        }

        return response.getBody();
    }
}
