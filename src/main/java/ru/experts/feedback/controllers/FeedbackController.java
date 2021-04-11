package ru.experts.feedback.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.entity.Feedback;
import ru.experts.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping()
    public List<Feedback> getAll(){
        return feedbackService.findAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id){
        System.out.println("Get feedback by id: " + id);
        return null;
    }

    @PostMapping()
    public String addPerson(@RequestBody Feedback feedback) {
        if(feedback != null) {
            feedbackService.insert(feedback);
            return "Added a person";
        } else {
            return "Request does not contain a body";
        }
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        System.out.println("Delete by id: " + id);
        return false;
    }
}
