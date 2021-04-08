package ru.experts.feedback.dto;

import org.springframework.stereotype.Service;
import ru.experts.feedback.domain.Answer;
import ru.experts.feedback.domain.Template;

import java.util.List;
import java.util.UUID;

/**
 * Сущность для изменения фидбека
 */
public class EditFeedbackRequest {
    private String fullName;
    private String email;
    private Service service;
    private List<Answer> answers;
}
