package ru.experts.feedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Template;
import ru.experts.feedback.exceptions.FeedbackNotFoundException;
import ru.experts.feedback.exceptions.TemplateNotFoundException;
import ru.experts.feedback.repositories.TemplateRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/templates")
public class TemplateController {

    private static final Logger log = LoggerFactory.getLogger(FeedbackController.class);

    private final TemplateRepository repository;

    public TemplateController(TemplateRepository repository) {
        this.repository = repository;
    }


    @GetMapping()
    public List<Template> getAll(){
        log.debug("get all templates");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Template getById(@PathVariable("id") UUID id){
        log.debug("get template by id" + id);
        return repository.findById(id).orElseThrow(() -> new FeedbackNotFoundException(id));
    }

    @PostMapping("/create")
    public Template create(@RequestBody Template template){
        log.debug("Create new template");
        return repository.save(template);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") UUID id){
        log.debug("Delete template");
        repository.findById(id).
                map(template -> {
                    template.changeDeleted();
                    return template;
                })
                .orElseThrow(()-> new TemplateNotFoundException(id));
    }
}
