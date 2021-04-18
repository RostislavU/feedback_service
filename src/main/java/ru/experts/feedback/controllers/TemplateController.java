package ru.experts.feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Template;
import ru.experts.feedback.dto.template.EditTemplateRequestDto;
import ru.experts.feedback.services.template.TemplateService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/templates")
public class TemplateController {

    public TemplateController(){}

    @Autowired
    private TemplateService templateService;

    @GetMapping()
    public List<Template> getAll(){
        return templateService.getAll();
    }

    @GetMapping("/{id}")
    public Template getById(@PathVariable("id") UUID id){
        return templateService.getById(id);
    }

    @PostMapping("/create")
    public Template create(@RequestBody EditTemplateRequestDto request){
        return templateService.create(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") UUID id){
        templateService.delete(id);
    }

    /*
    @GetMapping("/{template-id}/add-question/{question-id}")
    public Template addQuestion(@PathVariable("template-id") UUID templateId, @PathVariable("question-id") UUID questionId){
        ...
    }*/
}
