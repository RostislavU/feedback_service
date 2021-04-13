package ru.experts.feedback.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ValidationDataException extends RuntimeException {
    public ValidationDataException(String message) {super();}
}

@ControllerAdvice
class ValidationDataAdvice {
    @ResponseBody
    @ExceptionHandler(ValidationDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String validationDataExceptionHandler(ValidationDataException ex) {
        return ex.getMessage();
    }
}
