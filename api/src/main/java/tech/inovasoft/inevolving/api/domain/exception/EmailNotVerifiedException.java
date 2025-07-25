package tech.inovasoft.inevolving.api.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EmailNotVerifiedException extends RuntimeException {

    private final HttpStatus httpStatus;

    public EmailNotVerifiedException(String message) {
        super(message);
        this.httpStatus = HttpStatus.UNAUTHORIZED;
    }

}
