package ru.experts.feedback.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.experts.feedback.domain.Owner;
import ru.experts.feedback.domain.Owner.OwnerBuilder;
import ru.experts.feedback.dto.EditOwnerRequest;
import ru.experts.feedback.exceptions.ValidationDataException;
import ru.experts.feedback.repositories.OwnerRepository;

import java.util.List;

@Service
@Slf4j
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner registration(EditOwnerRequest request) throws ValidationDataException{
        OwnerBuilder ownerBuilder = Owner.builder()
                .hash(request.getHash())
                .name(request.getName());

        if (request.getEvent()!=null){
            ownerBuilder.event(request.getEvent());
        }
        Owner owner = ownerBuilder.build();
        try {
            return ownerRepository.save(owner);
        }
        catch (DataIntegrityViolationException ex){
            log.error(ex.getMessage());
            throw new ValidationDataException("Некорректный формат входных данных");
        }


    }

    public List<Owner> getAll(){
        return ownerRepository.findAll();
    }

}
