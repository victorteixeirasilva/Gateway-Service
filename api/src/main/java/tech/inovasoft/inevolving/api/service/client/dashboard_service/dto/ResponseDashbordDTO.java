package tech.inovasoft.inevolving.api.service.client.dashboard_service.dto;

import java.util.List;
import java.util.UUID;

public record ResponseDashbordDTO(
        UUID idUser,
        List<ResponseCategoryDTO> categoryDTOList
) {
}
