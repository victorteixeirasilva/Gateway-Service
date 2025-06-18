package tech.inovasoft.inevolving.api.service.client.finance_service.dto;

import java.util.UUID;

public record FinancePlanning(
        UUID idUser,
        Double wage
) {
}
