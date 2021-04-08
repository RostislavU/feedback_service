package ru.experts.feedback.services.feedback;

import org.springframework.stereotype.Component;
import ru.experts.feedback.domain.Feedback;
import ru.experts.feedback.domain.Customer;
import ru.experts.feedback.domain.Template;
import ru.experts.feedback.repositories.FeedbackRepository;

import static java.time.LocalDateTime.now;

@Component
public class FeedbackCreator {

    private final FeedbackRepository repository;

    public FeedbackCreator(FeedbackRepository repository) {
        this.repository = repository;
    }

    public Feedback createForService(Customer customer, String email, String fullName, boolean isAnonymously, Template template){


        return Feedback.builder()
                .createDatetime(now())
                .customer(customer)
                .email(email)
                .fullName(fullName)
                .isAnonymously(isAnonymously)
                .template(template)
                .build();
    }
}
