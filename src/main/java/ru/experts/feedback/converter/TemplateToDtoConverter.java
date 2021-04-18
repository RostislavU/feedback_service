package ru.experts.feedback.converter;

import org.springframework.core.convert.converter.Converter;
import ru.experts.feedback.domain.Template;
import ru.experts.feedback.dto.template.TemplateDto;

public class TemplateToDtoConverter implements Converter<Template, TemplateDto> {

    @Override
    public TemplateDto convert(Template template) {
        return TemplateDto.builder()
                .id(template.getId())
                .name(template.getName())
                .comment(template.getComment())
                .createDateTime(template.getCreateDatetime())
                .orderedQuestions(template.getOrderedQuestions())
                .build();
    }
}
