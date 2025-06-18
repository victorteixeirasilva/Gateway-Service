package tech.inovasoft.inevolving.api.service.client.task_service.dto;

import java.sql.Date;
import java.util.UUID;

public record ResponseTaskDTO(
        UUID id,
        String nameTask,
        String descriptionTask,
        String status,
        Date dateTask,
        UUID idObjective,
        UUID idUser,
        String cancellationReason
) {
}
