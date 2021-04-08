package ru.experts.feedback.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public class TemplateNotFoundException extends RuntimeException{

    public TemplateNotFoundException(UUID id) {
        super("Could not find template by id: " + id);
    }
}

@ControllerAdvice
class TemplateNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TemplateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String templateNotFoundHandler(TemplateNotFoundException ex) {
        return ex.getMessage();
    }
}