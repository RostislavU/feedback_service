package ru.experts.feedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Feedback;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.repositories.FeedbackRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private static final Logger log = LoggerFactory.getLogger(FeedbackController.class);

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
