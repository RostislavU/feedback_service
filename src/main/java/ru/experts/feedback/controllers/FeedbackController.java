package ru.experts.feedback.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Feedback;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.repositories.FeedbackRepository;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackRepository repository;

    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Feedback> getAll(){
        log.debug("get all feedbacks");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Feedback getById(@PathVariable("id") UUID id){
        log.debug("get feedback by id" + id);
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Не найден фидбек с id" + id));
    }

    @PostMapping("/create")
    public Feedback create(@RequestBody Feedback feedback){
        log.debug("Create new feedback");
        return repository.save(feedback);
    }

}
