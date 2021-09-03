package ru.experts.feedback.services.feedback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.experts.feedback.domain.CreationInfo;
import ru.experts.feedback.domain.Feedback;
import ru.experts.feedback.dto.CreateFeedbackRequestDto;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.repositories.FeedbackRepository;

import java.util.UUID;

@Service
@Slf4j
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback createForOwner(CreateFeedbackRequestDto request, UUID templateId) {
        log.debug("Создание обратной связи");
        return Feedback.builder()
                .creationInfo(new CreationInfo(request.getFullName(), request.getEmail()))
                .templateId(templateId)
                .answers(request.getAnswers())
                .isRead(false)
                .build();
    }

    public Feedback getById(UUID id) {
        log.debug("Запрос шаблона по id" + id);
        return feedbackRepository.findById(id).orElseThrow(() -> new NotFoundException("Не найдена обратная связь с id " + id));
    }
}
