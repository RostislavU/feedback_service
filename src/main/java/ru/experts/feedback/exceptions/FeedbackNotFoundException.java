package ru.experts.feedback.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public class FeedbackNotFoundException extends RuntimeException{
    public FeedbackNotFoundException(UUID id) {
        super("Could not find feedback by id: " + id);
    }
}


@ControllerAdvice
class FeedbackNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FeedbackNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String feedbackNotFoundHandler(FeedbackNotFoundException ex) {
        return ex.getMessage();
    }
}
