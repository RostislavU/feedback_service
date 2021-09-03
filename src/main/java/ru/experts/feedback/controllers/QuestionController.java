package ru.experts.feedback.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Question;
import ru.experts.feedback.dto.EditQuestionRequestDto;
import ru.experts.feedback.services.question.QuestionService;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/questions")
public class QuestionController {

    public QuestionController() {
    }

    @Autowired
    private QuestionService questionService;

    @GetMapping()
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable("id") UUID id) {
        return questionService.getById(id);
    }

    @PostMapping("/create")
    public Question create(@RequestBody EditQuestionRequestDto request) {
        return questionService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        questionService.deleteById(id);
    }


}
