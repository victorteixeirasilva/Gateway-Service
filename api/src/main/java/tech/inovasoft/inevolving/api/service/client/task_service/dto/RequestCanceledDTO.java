package tech.inovasoft.inevolving.api.service.client.task_service.dto;

import tech.inovasoft.inevolving.api.domain.dto.request.CanceledRequestDTO;

import java.util.UUID;

public record RequestCanceledDTO(
        UUID idUser,
        UUID idTask,
        String cancellationReason
) {
    public RequestCanceledDTO(UUID idUser, CanceledRequestDTO dto) {
        this(
                idUser,
                dto.idTask(),
                dto.cancellationReason()
        );
    }
}
