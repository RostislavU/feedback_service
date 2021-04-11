package ru.experts.feedback.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.experts.feedback.dto.EditOwnerRequest;
import ru.experts.feedback.services.OwnerService;

@RestController
@Slf4j
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    @PostMapping("/registration")
    public boolean registration(@RequestBody EditOwnerRequest request){
        try {
            ownerService.registration(request);
            return true;
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            return false;
        }
    }
}
