package tech.inovasoft.inevolving.api.domain.dto.request;

import java.util.UUID;

public record CanceledRequestDTO(
        UUID idTask,
        String cancellationReason
) {
}
