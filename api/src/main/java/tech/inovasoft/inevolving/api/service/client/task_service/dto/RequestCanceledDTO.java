package tech.inovasoft.inevolving.api.service.client.task_service.dto;

import java.util.UUID;

public record RequestCanceledDTO(
        UUID idUser,
        UUID idTask,
        String cancellationReason
) {
}
