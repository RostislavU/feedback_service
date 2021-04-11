package ru.experts.feedback.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.experts.feedback.enums.QuestionType;

/**
 * Сущность для изменения/создания вопроса
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditQuestionRequest {
    private String text;
    private QuestionType type;
    private String struct;
}
