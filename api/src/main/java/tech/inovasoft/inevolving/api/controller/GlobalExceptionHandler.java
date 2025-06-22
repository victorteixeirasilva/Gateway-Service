package tech.inovasoft.inevolving.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;
import tech.inovasoft.inevolving.api.domain.dto.response.ExceptionResponse;
import tech.inovasoft.inevolving.api.domain.exception.*;

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

    @ExceptionHandler(CategoriesServiceException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleCategoriesServiceException(CategoriesServiceException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getHttpStatus(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .status(ex.getHttpStatus())
                .body(response));
    }

    @ExceptionHandler(DashboardServiceException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleDashboardServiceException(DashboardServiceException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getHttpStatus(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .status(ex.getHttpStatus())
                .body(response));
    }

    @ExceptionHandler(EmailNotVerifiedException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleEmailNotVerifiedException(EmailNotVerifiedException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getHttpStatus(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .status(ex.getHttpStatus())
                .body(response));
    }

    @ExceptionHandler(EmailServiceException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleEmailServiceException(EmailServiceException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getHttpStatus(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .status(ex.getHttpStatus())
                .body(response));
    }

    @ExceptionHandler(FinanceServiceException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleFinanceServiceException(FinanceServiceException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getHttpStatus(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .status(ex.getHttpStatus())
                .body(response));
    }

    @ExceptionHandler(MotivationServiceException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleMotivationServiceException(MotivationServiceException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getHttpStatus(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .status(ex.getHttpStatus())
                .body(response));
    }

    @ExceptionHandler(ObjectivesServiceException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleObjectivesServiceException(ObjectivesServiceException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getHttpStatus(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .status(ex.getHttpStatus())
                .body(response));
    }

    @ExceptionHandler(TasksServiceException.class)
    public Mono<ResponseEntity<ExceptionResponse>> handleTasksServiceException(TasksServiceException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getHttpStatus(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .status(ex.getHttpStatus())
                .body(response));
    }

}
