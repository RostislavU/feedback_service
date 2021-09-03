package ru.experts.feedback.services.answer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ru.experts.feedback.converter.OwnerToDtoConverter;
import ru.experts.feedback.domain.Answer;
import ru.experts.feedback.domain.Feedback;
import ru.experts.feedback.domain.Owner;
import ru.experts.feedback.domain.Template;
import ru.experts.feedback.dto.answer.EditAnswerRequestDto;
import ru.experts.feedback.dto.owner.OwnerDto;
import ru.experts.feedback.dto.template.EditTemplateRequestDto;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.exceptions.ValidationDataException;
import ru.experts.feedback.repositories.AnswerRepository;
import ru.experts.feedback.repositories.FeedbackRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

@Service
@Slf4j
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final FeedbackRepository feedbackRepository;

    public AnswerService(AnswerRepository answerRepository, FeedbackRepository feedbackRepository) {
        this.answerRepository = answerRepository;
        this.feedbackRepository = feedbackRepository;
    }

    public List<Answer> getAll(UUID feedback_id) {

        return this.answerRepository.findAll().stream().filter(answer -> answer.getFeedback().getId() == feedback_id).collect(Collectors.toList());
    }

    public Answer getById(UUID id) {
        return answerRepository.findById(id).orElseThrow(() -> new NotFoundException("Ответ не найден"));

    }

    public Answer create(UUID feedback_id, EditAnswerRequestDto request) {
        Feedback feedback = this.feedbackRepository.getOne(feedback_id);
        Answer answer = Answer.builder().questionId(request.getQuestion_id()).feedback(feedback).rating(request.getRating()).value(request.getValue()).build();

        try {
            return answerRepository.save(answer);
        } catch (DataIntegrityViolationException ex) {
            log.error(ex.getMessage());
            throw new ValidationDataException("Некорректные данные");
        }
    }
}

