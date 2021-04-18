package ru.experts.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.experts.feedback.domain.Answer;
import java.util.Set;
import java.util.UUID;

/**
 * Сущность для создания/изменения фидбека
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFeedbackRequestDto {

    private UUID ownerId;
    private UUID templateId;
    private String email;
    private String fullName;
    private Set<Answer> answers;
}
