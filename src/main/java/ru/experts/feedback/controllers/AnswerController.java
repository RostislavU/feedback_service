package ru.experts.feedback.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Answer;
import ru.experts.feedback.dto.answer.EditAnswerRequestDto;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.repositories.AnswerRepository;
import ru.experts.feedback.services.answer.AnswerService;
import ru.experts.feedback.services.template.TemplateService;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/answers")
public class AnswerController {

    public AnswerController() {
    }

    @Autowired
    private AnswerService answerService;

    @GetMapping("/{feedback_id}")
    public List<Answer> getAll(@PathVariable("feedback_id") UUID feedback_id) {
        log.debug("Get all answers");
        return answerService.getAll(feedback_id);
    }

    @GetMapping("/{answer_id}")
    public Answer getById(@PathVariable("answer_id") UUID id) {
        log.debug("Get answer by id" + id);
        return answerService.getById(id);
    }

    @PostMapping("{feedback_id}/add")
    public void create(@PathVariable("feedback_id") UUID feedback_id, @RequestBody EditAnswerRequestDto editAnswerRequestDto) {
        log.debug("Create new answer");
        answerService.create(feedback_id, editAnswerRequestDto);
    }

}
