package ru.experts.feedback.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @GetMapping()
    public String getAll(){
        System.out.println("Get all feedbacks");
        return null;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id){
        System.out.println("Get feedback by id: " + id);
        return null;
    }

    @PostMapping("/new")
    public boolean create(){
        System.out.println("Create new feedback");
        return false;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        System.out.println("Delete by id: " + id);
        return false;
    }
}
