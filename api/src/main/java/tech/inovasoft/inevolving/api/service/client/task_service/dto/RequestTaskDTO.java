package tech.inovasoft.inevolving.api.service.client.task_service.dto;

import java.time.LocalDate;
import java.util.UUID;

public record RequestTaskDTO(
        String nameTask,
        String descriptionTask,
        LocalDate dateTask,
        UUID idObjective,
        UUID idUser
){
}
