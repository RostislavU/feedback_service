package ru.experts.feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Owner;
import ru.experts.feedback.dto.EditOwnerRequest;
import ru.experts.feedback.services.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/registration")
    public Owner registration(@RequestBody EditOwnerRequest request){
            return ownerService.registration(request);
    }

    @GetMapping()
    public List<Owner> getAll(){
        return ownerService.getAll();
    }
}
