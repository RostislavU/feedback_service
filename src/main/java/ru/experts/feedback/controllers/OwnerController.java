package ru.experts.feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.experts.feedback.domain.Owner;
import ru.experts.feedback.dto.owner.CreateOwnerRequestDto;
import ru.experts.feedback.dto.owner.OwnerDto;
import ru.experts.feedback.services.OwnerService;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/registration")
    public OwnerDto registration(@RequestBody CreateOwnerRequestDto request) {
        return ownerService.registration(request);
    }

    @GetMapping()
    public Set<OwnerDto> getAll() {
        return ownerService.getAll();
    }

    @GetMapping("/{id}")
    public OwnerDto getById(@PathVariable("id") UUID id) {
        return ownerService.getById(id);
    }
}
