package tech.inovasoft.inevolving.api.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MotivationServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public MotivationServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
