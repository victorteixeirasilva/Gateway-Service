package tech.inovasoft.inevolving.api.service.client.objectives_service.dto;

import java.sql.Date;
import java.util.UUID;

public record Objective(
        UUID id,
        String nameObjective,
        String descriptionObjective,
        String statusObjective,
        Date completionDate,
        UUID idUser
) {
}
