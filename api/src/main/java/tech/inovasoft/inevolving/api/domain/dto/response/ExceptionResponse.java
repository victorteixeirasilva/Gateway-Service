package tech.inovasoft.inevolving.api.domain.dto.response;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(
        HttpStatus httpStatus,
        String message
) {
}
