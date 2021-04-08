package ru.experts.feedback.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super();
    }
}


@ControllerAdvice
class FeedbackNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String feedbackNotFoundHandler(NotFoundException ex) {
        return ex.getMessage();
    }
}
