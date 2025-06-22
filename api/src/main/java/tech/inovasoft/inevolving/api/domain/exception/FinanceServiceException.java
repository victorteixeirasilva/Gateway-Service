package tech.inovasoft.inevolving.api.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FinanceServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public FinanceServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
