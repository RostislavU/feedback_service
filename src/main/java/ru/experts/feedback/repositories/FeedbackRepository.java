package ru.experts.feedback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.experts.feedback.domain.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {
}
