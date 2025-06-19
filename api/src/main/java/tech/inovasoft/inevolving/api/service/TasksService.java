package tech.inovasoft.inevolving.api.service;

import org.springframework.stereotype.Service;
import tech.inovasoft.inevolving.api.domain.dto.request.CanceledRequestDTO;
import tech.inovasoft.inevolving.api.domain.dto.request.TaskRequestDTO;
import tech.inovasoft.inevolving.api.service.client.task_service.dto.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TasksService {
    public ResponseTaskDTO addTask(UUID idUser, TaskRequestDTO dto) {
        //TODO: implement
        return null;
    }

    public ResponseRepeatTaskDTO repeatTask(UUID idUser, DaysOfTheWeekDTO dto, UUID idTask, Date startDate, Date endDate) {
        //TODO: implement
        return null;
    }

    public ResponseTaskDTO updateTask(UUID idUser, RequestUpdateTaskDTO dto, UUID idTask) {
        //TODO: implement
        return null;
    }

    public ResponseUpdateRepeatTaskDTO updateTasksAndTheirFutureRepetitions(UUID idUser, RequestUpdateRepeatTaskDTO dto, UUID idTask, Date endDate) {
        //TODO: implement
        return null;
    }

    public ResponseTaskDTO updateTaskStatusToDo(UUID idUser, UUID idTask) {
        //TODO: implement
        return null;
    }

    public ResponseTaskDTO updateTaskStatusInProgress(UUID idUser, UUID idTask) {
        //TODO: implement
        return null;
    }

    public ResponseTaskDTO updateTaskStatusDone(UUID idUser, UUID idTask) {
        //TODO: implement
        return null;
    }

    public ResponseTaskDTO updateTaskStatusLate(UUID idUser, UUID idTask) {
        //TODO: implement
        return null;
    }

    public ResponseTaskDTO updateTaskStatusCanceled(UUID idUser, CanceledRequestDTO dto) {
        //TODO: implement
        return null;
    }

    public ResponseMessageDTO deleteTask(UUID idUser, UUID idTask) {
        //TODO: implement
        return null;
    }

    public ResponseDeleteTasksDTO deleteTasksAndTheirFutureRepetitions(UUID idUser, UUID idTask, Date date) {
        //TODO: implement
        return null;
    }

    public ResponseMessageDTO lockTaskByObjective(UUID idUser, Date completionDate, UUID idObjective) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksInDateRange(UUID idUser, Date startDate, Date endDate) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksInDateRangeByObjectiveId(UUID idUser, UUID idObjective, Date startDate, Date endDate) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksByObjectiveId(UUID idUser, UUID idObjective) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksInDate(UUID idUser, Date date) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksLate(UUID idUser) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksToDoInDateRange(UUID idUser, Date startDate, Date endDate) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksToDoInDate(UUID idUser, Date date) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksInProgressInDateRange(UUID idUser, Date startDate, Date endDate) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksInProgressInDate(UUID idUser, Date date) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksDoneInDateRange(UUID idUser, Date startDate, Date endDate) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksDoneInDate(UUID idUser, Date date) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksCanceledInDateRange(UUID idUser, Date startDate, Date endDate) {
        //TODO: implement
        return null;
    }

    public List<Task> getTasksCanceledInDate(UUID idUser, Date date) {
        //TODO: implement
        return null;
    }
}
