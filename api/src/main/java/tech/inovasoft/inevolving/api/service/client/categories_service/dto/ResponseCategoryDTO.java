package tech.inovasoft.inevolving.api.service.client.categories_service.dto;

import java.util.UUID;

public record ResponseCategoryDTO(
        UUID id,
        String categoryName,
        String categoryDescription
) {
}
