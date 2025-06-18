package tech.inovasoft.inevolving.api.service.client.categories_service.dto;

import java.util.List;

public record ResponseObjectivesByCategory(
        ResponseCategoryDTO category,
        List<ResponseObjectiveDTO> objectives
) {
}
