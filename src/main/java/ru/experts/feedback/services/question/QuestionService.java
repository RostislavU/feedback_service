package ru.experts.feedback.services.question;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.experts.feedback.domain.Question;
import ru.experts.feedback.dto.EditQuestionRequestDto;
import ru.experts.feedback.exceptions.NotFoundException;
import ru.experts.feedback.repositories.QuestionRepository;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getById(UUID id) {
        log.debug("Запрос вопроса по id: " + id);
        return questionRepository.findById(id).orElseThrow(() -> new NotFoundException("Не найден вопрос с id: " + id));
    }

    public List<Question> getAll() {
        log.debug("Запрос всех вопросов");
        return questionRepository.findAll();
    }

    public Question create(EditQuestionRequestDto request) {
        log.debug("Создание вопроса");
        Question question = Question.builder()
                .text(request.getText())
                .isDeleted(false)
                .struct(request.getStruct())
                .type(request.getType())
                .build();
        questionRepository.save(question);
        return question;
    }

    public void deleteById(UUID id) {
        log.debug("Удаление вопроса с id:" + id);
        questionRepository.save(
                questionRepository.findById(id).map(question -> {
                            question.setDeleted(true);
                            return question;
                        })
                        .orElseThrow(() -> new NotFoundException("Не удалось найти вопрос с id: " + id)));
    }
}
