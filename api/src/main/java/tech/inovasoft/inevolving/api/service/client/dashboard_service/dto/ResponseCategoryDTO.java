package tech.inovasoft.inevolving.api.service.client.dashboard_service.dto;

import java.util.List;
import java.util.UUID;

public record ResponseCategoryDTO(
        UUID id,
        String categoryName,
        String categoryDescription,
        List<ResponseObjectiveDTO> objectives
) {
}
