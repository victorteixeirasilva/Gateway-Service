package tech.inovasoft.inevolving.api.service.client.categories_service.dto;

import java.util.List;
import java.util.UUID;

public record ResponseCategoriesDTO(
        UUID idUser,
        List<ResponseCategoryDTO> categories
) {
}
