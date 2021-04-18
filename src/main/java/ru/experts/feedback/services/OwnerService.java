package ru.experts.feedback.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.experts.feedback.converter.OwnerToDtoConverter;
import ru.experts.feedback.converter.TemplateToTemplates;
import ru.experts.feedback.domain.Owner;
import ru.experts.feedback.domain.Owner.OwnerBuilder;
import ru.experts.feedback.domain.Template;
import ru.experts.feedback.dto.owner.CreateOwnerRequestDto;
import ru.experts.feedback.dto.owner.OwnerDto;
import ru.experts.feedback.dto.template.EditTemplateRequestDto;
import ru.experts.feedback.dto.template.TemplateDto;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.exceptions.ValidationDataException;
import ru.experts.feedback.repositories.OwnerRepository;
import ru.experts.feedback.repositories.TemplateRepository;
import ru.experts.feedback.services.template.TemplateService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    private TemplateService templateService;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public OwnerDto registration(CreateOwnerRequestDto request) throws ValidationDataException{

        Owner owner;
        OwnerBuilder ownerBuilder = Owner.builder()
                .createDatetime(LocalDateTime.now())
                .hash(request.getHash())
                .name(request.getName());

        if (request.getEvent()!=null){
            ownerBuilder.event(request.getEvent());
        }

        try {
            owner = ownerRepository.save(ownerBuilder.build());
        }
        catch (DataIntegrityViolationException ex){
            throw new ValidationDataException("Некорректный формат входных данных");
        }

        EditTemplateRequestDto templateRequestDto = new EditTemplateRequestDto(owner.getId(),
                "Первый шаблон",
                "Тестовый шаблон, параметры которого можно изменить",
                false);

        owner.setTemplates(new TemplateToTemplates().convert(templateService.create(templateRequestDto)));

        return new OwnerToDtoConverter().convert(owner);
    }

    public Set<OwnerDto> getAll(){

        final List<Owner> owners = ownerRepository.findAll();

        Set<OwnerDto> ownerDtoSet = new HashSet<>();
        for (Owner owner:
             owners) {
            ownerDtoSet.add(new OwnerToDtoConverter().convert(owner));
        }

        return ownerDtoSet;
    }

    public OwnerDto getById(UUID id){
        final Owner owner = ownerRepository.findById(id).orElseThrow(()->new NotFoundException("Пользователь не найден"));
        return new OwnerToDtoConverter().convert(owner);
    }
}
