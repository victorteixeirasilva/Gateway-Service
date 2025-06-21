package tech.inovasoft.inevolving.api.service.client.finance_service.dto;

import tech.inovasoft.inevolving.api.domain.dto.request.TransactionRequestDTO;

import java.time.LocalDate;
import java.util.UUID;

public record RequestTransactionDTO(
        UUID idUser,
        LocalDate date,
        String description,
        Double value
) {
    public RequestTransactionDTO(UUID idUser, TransactionRequestDTO dto) {
        this(
                idUser,
                dto.date(),
                dto.description(),
                dto.value()
        );
    }
}
