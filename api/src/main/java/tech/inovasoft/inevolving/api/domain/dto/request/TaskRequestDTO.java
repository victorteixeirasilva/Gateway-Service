package tech.inovasoft.inevolving.api.domain.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public record TaskRequestDTO(
        String nameTask,
        String descriptionTask,
        LocalDate dateTask,
        UUID idObjective
) {
}
