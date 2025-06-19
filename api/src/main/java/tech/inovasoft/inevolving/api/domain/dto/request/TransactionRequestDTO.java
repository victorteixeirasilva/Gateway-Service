package tech.inovasoft.inevolving.api.domain.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public record TransactionRequestDTO(
        LocalDate date,
        String description,
        Double value
) {
}
