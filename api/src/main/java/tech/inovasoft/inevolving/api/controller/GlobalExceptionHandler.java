package tech.inovasoft.inevolving.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.dto.response.ExceptionResponse;
import tech.inovasoft.inevolving.api.domain.exception.BooksServiceException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BooksServiceException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleBooksServiceException(BooksServiceException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getHttpStatus(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .status(ex.getHttpStatus())
                .body(response));
    }

}
