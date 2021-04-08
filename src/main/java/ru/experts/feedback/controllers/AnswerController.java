package ru.experts.feedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Answer;
import ru.experts.feedback.exceptions.AnswerNotFoundException;
import ru.experts.feedback.repositories.AnswerRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private static final Logger log = LoggerFactory.getLogger(FeedbackController.class);

    private final AnswerRepository repository;

    public AnswerController(AnswerRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Answer> getAll(){
        log.debug("Get all answers");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Answer getById(@PathVariable("id") UUID id){
        log.debug("Get answer by id" + id);
        return repository.findById(id).orElseThrow(() -> new AnswerNotFoundException(id));
    }

    @PostMapping("/create")
    public void create(@RequestBody Answer answer){
        log.debug("Create new answer");
        repository.save(answer);
    }

}
