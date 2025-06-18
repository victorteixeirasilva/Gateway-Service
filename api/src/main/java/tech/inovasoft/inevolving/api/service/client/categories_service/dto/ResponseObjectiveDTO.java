package tech.inovasoft.inevolving.api.service.client.categories_service.dto;

import java.sql.Date;
import java.util.UUID;

public record ResponseObjectiveDTO(
        UUID id,
        String nameObjective,
        String descriptionObjective,
        String statusObjective,
        Date completionDate,
        UUID idUser
) {
}
