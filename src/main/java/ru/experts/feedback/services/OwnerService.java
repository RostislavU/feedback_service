package ru.experts.feedback.services;

import org.springframework.stereotype.Service;
import ru.experts.feedback.domain.Owner;
import ru.experts.feedback.domain.Owner.OwnerBuilder;
import ru.experts.feedback.dto.EditOwnerRequest;
import ru.experts.feedback.repositories.OwnerRepository;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner registration(EditOwnerRequest request){
        OwnerBuilder ownerBuilder = Owner.builder()
                .hash(request.getHash())
                .name(request.getName());

        if (!request.getEvent().isEmpty()){
            ownerBuilder.event(request.getEvent());
        }

        Owner owner = ownerBuilder.build();
        ownerRepository.save(owner);
        return owner;
    }

}
