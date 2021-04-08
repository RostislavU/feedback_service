package ru.experts.feedback.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public class AnswerNotFoundException extends RuntimeException{
    public AnswerNotFoundException(UUID id) {
        super("Could not find answer by id: " + id);
    }
}

@ControllerAdvice
class AnswerNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(AnswerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String answerNotFoundHandler(AnswerNotFoundException ex) {
        return ex.getMessage();
    }
}
