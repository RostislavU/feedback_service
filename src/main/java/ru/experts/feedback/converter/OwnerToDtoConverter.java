package ru.experts.feedback.converter;

import ru.experts.feedback.domain.Owner;
import ru.experts.feedback.domain.Template;
import ru.experts.feedback.dto.owner.OwnerDto;


import org.springframework.core.convert.converter.Converter;
import ru.experts.feedback.dto.template.TemplateDto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class OwnerToDtoConverter implements Converter<Owner, OwnerDto> {

    @Override
    public OwnerDto convert(Owner owner) {;
        Set<TemplateDto> templateDtoSet = new HashSet<>();
        for (Template temp:
                owner.getTemplates()) {
            templateDtoSet.add( new TemplateToDtoConverter().convert(temp));
        }

        return OwnerDto.builder()
                .id(owner.getId())
                .createDatetime(LocalDateTime.now())
                .name(owner.getName())
                .templateDtoSet(templateDtoSet)
                .event(owner.getEvent())
                .build();
    }
}
