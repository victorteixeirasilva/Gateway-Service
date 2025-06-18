package tech.inovasoft.inevolving.api.service.client.categories_service.dto;

import java.util.UUID;

public record ResponseCategoryAndNewObjectiveDTO(
        String message,
        UUID idCategory,
        UUID idUser,
        String categoryName,
        String categoryDescription,
        ResponseObjectiveDTO objective
) {
}
