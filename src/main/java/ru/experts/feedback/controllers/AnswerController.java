package ru.experts.feedback.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Answer;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.repositories.AnswerRepository;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/answers")
public class AnswerController {

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
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Не найден ответ с id " + id));
    }

    @PostMapping("/create")
    public void create(@RequestBody Answer answer){
        log.debug("Create new answer");
        repository.save(answer);
    }

}
