package ru.experts.feedback.converter;

import org.springframework.core.convert.converter.Converter;
import ru.experts.feedback.domain.Template;

import java.util.HashSet;
import java.util.Set;

public class TemplateToTemplates implements Converter<Template, Set<Template>> {

    @Override
    public Set<Template> convert(Template template) {
        Set<Template> templateSet = new HashSet<>();
        templateSet.add(template);
        return templateSet;
    }

}
