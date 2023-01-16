package ru.levelup.lesson9_10.rest.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.levelup.lesson9_10.dto.error.RestApiErrorDto;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String VALIDATION_FAILED = "VALIDATION_FAILED";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        log.warn("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(VALIDATION_FAILED);

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            apiErrorDto.getError().addField(fieldName, errorMessage);
        });
        return new ResponseEntity<>(apiErrorDto, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status,
                                                                         WebRequest request) {
        log.warn("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(VALIDATION_FAILED, ex.getMessage());
        return new ResponseEntity<>(apiErrorDto, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(VALIDATION_FAILED);
        ex.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            apiErrorDto.getError().addField(fieldName, errorMessage);
        });
        return new ResponseEntity<>(apiErrorDto, headers, status);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public RestApiErrorDto handleIllegalExceptions(IllegalArgumentException ex) {
        log.warn("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(VALIDATION_FAILED);
        apiErrorDto.getError().setMessage("Проверьте введенные данные");
        return apiErrorDto;
    }

}
