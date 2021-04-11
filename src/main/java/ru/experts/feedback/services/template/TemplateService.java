package ru.experts.feedback.services.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.experts.feedback.domain.Template;
import ru.experts.feedback.dto.EditTemplateRequest;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.repositories.TemplateRepository;

import static java.time.LocalDateTime.now;
import java.util.List;
import java.util.UUID;

/**
 * Класс предоставялет методы для взаимодейстия с {@link TemplateRepository}.
 * Осуществляет любое взаимодействие с базой данных templates.
 *
 */
@Service
@Slf4j
public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }


    public Template create(EditTemplateRequest request){
        log.debug("Создание шаблона с именем " + request.getName());
        return templateRepository.save(Template.builder()
                .name(request.getName())
                .isDeleted(false)
                .createDatetime(now())
                .build());
    }

    public List<Template> getAll(){

        return templateRepository.findAll();
    }

    public Template getById(UUID id){

        log.debug("Запрос шаблона по id: " + id);
        return templateRepository.findById(id).orElseThrow(()-> new NotFoundException("Не найден шаблон с id " + id));
    }

    public void delete(UUID id){
        log.debug("Шаблон помечен как удаленный; id: " + id);
        templateRepository.findById(id).
                map(template -> {
                    template.setDeleted();
                    return template;
                })
                .orElseThrow(()-> new NotFoundException("Не найден шаблон с id " + id));
    }

}
