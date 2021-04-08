package ru.experts.feedback.services.template;

import org.springframework.stereotype.Component;
import ru.experts.feedback.domain.Question;
import ru.experts.feedback.domain.Template;

import java.util.Set;

import static java.time.LocalDateTime.now;

/**
 * Реализует логику создания шаблона опроса
 */
@Component
public class TemplateCreator {


    /**
     * Конструирует шаблон исходя из списка вопросов вопросов
     *
     * */
    public Template create(Set<Question> questions, String creator){

        return Template.builder()
                .questions(questions)
                .creator(creator)
                .isDeleted(false)
                .createDatetime(now())
                .build();
    }
}
