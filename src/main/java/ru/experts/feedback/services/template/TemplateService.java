package ru.experts.feedback.services.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.experts.feedback.domain.Owner;
import ru.experts.feedback.domain.Template;
import ru.experts.feedback.dto.template.EditTemplateRequestDto;
import ru.experts.feedback.dto.template.TemplateDto;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.exceptions.ValidationDataException;
import ru.experts.feedback.repositories.OwnerRepository;
import ru.experts.feedback.repositories.TemplateRepository;

import static java.time.LocalDateTime.now;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Класс предоставялет методы для взаимодейстия с {@link TemplateRepository}.
 * Осуществляет любое взаимодействие с базой данных templates.
 */
@Service
@Slf4j
public class TemplateService {

    private final TemplateRepository templateRepository;
    private final OwnerRepository ownerRepository;

    public TemplateService(TemplateRepository templateRepository, OwnerRepository ownerRepository) {
        this.templateRepository = templateRepository;
        this.ownerRepository = ownerRepository;
    }

    public Template create(EditTemplateRequestDto request) {
        Owner owner = ownerRepository.findById(request.getOwnerId()).orElseThrow(() -> new NotFoundException("Не найден владелец с указанным id:" + request.getOwnerId()));

        Template template = Template.builder()
                .owner(owner)
                .name(request.getName())
                .comment(request.getComment())
                .isDeleted(false)
                .createDatetime(now())
                .build();
        try {
            return templateRepository.save(template);
        } catch (DataIntegrityViolationException ex) {
            log.error(ex.getMessage());
            throw new ValidationDataException("Некорректные данные");
        }
    }

    public Template editTemplate(UUID id, EditTemplateRequestDto request) {
        Template oldTemplate = templateRepository.getOne(id);

        Template newTemplate = Template.builder().id(oldTemplate.getId()).comment(request.getComment()).isAvailable(request.isAvailable()).name(request.getName()).build();

        try {
            return templateRepository.save(newTemplate);
        } catch (DataIntegrityViolationException ex) {
            log.error(ex.getMessage());
            throw new ValidationDataException("Некорректные данные");
        }
    }

    public List<Template> getAllAvailable() {
        log.debug("Запрос всех доступных шаблонов");
        return templateRepository.findAll().stream().filter(Template::isAvailable).collect(Collectors.toList());
    }

    public Template getById(UUID id) {
        log.debug("Запрос шаблона по id: " + id);
        return templateRepository.findById(id).orElseThrow(() -> new NotFoundException("Не найден шаблон с id " + id));
    }

    public List<Template> getByOwnerId(UUID ownerId) {
        log.debug("Запрос шаблона по id владельца: " + ownerId);
        return templateRepository.findAll().stream().filter((template) -> template.getOwner().getId() == ownerId).collect(Collectors.toList());
    }

    public void delete(UUID id) {
        log.debug("Шаблон помечен как удаленный; id: " + id);
        templateRepository.findById(id).
                map(template -> {
                    template.setAvailable(false);
                    template.setDeleted(true);
                    return template;
                })
                .orElseThrow(() -> new NotFoundException("Не найден шаблон с id " + id));
    }
}
