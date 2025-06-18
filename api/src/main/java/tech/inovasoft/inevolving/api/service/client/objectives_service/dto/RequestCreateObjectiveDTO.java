package tech.inovasoft.inevolving.api.service.client.objectives_service.dto;

import java.util.UUID;

public record RequestCreateObjectiveDTO(
        String nameObjective,
        String descriptionObjective,
        UUID idUser
) {
}
