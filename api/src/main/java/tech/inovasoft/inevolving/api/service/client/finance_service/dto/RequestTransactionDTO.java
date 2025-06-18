package tech.inovasoft.inevolving.api.service.client.finance_service.dto;

import java.time.LocalDate;
import java.util.UUID;

public record RequestTransactionDTO(
        UUID idUser,
        LocalDate date,
        String description,
        Double value
) {
}
