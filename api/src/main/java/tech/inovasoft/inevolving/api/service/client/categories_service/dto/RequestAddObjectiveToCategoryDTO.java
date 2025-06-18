package tech.inovasoft.inevolving.api.service.client.categories_service.dto;

import java.util.UUID;

public record RequestAddObjectiveToCategoryDTO(
        UUID idCategory,
        UUID idObjective
) {
}
