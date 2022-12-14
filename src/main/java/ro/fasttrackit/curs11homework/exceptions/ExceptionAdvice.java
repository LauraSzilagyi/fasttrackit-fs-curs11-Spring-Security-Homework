package ro.fasttrackit.curs11homework.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleResourceNotFound(BadRequestException ex) {
        return new ApiError("ERROR", ex.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    ApiError handleResourceNotFound(EntityNotFoundException ex) {
        return new ApiError("ERROR", ex.getMessage());
    }
}

record ApiError(String code, String message) {
}