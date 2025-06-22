package tech.inovasoft.inevolving.api.domain.exception;

import org.springframework.http.HttpStatus;

public class EmailNotVerifiedException extends RuntimeException {

    public EmailNotVerifiedException(String message) {
        super(message);
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
    }

}
