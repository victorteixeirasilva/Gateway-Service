package tech.inovasoft.inevolving.api.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ObjectivesServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public ObjectivesServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
