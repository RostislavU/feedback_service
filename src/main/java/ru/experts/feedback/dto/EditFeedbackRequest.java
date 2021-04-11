package ru.experts.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.experts.feedback.domain.Answer;
import ru.experts.feedback.domain.Customer;

import java.util.List;

/**
 * Сущность для изменения фидбека
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditFeedbackRequest {
    private String fullName;
    private String email;
    private Customer customer;
    private List<Answer> answers;
}
