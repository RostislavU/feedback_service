package ru.experts.feedback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.experts.feedback.entity.Feedback;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {

    @Query(value = "select * from feedback where service = EXPERTS_CONCLUSION", nativeQuery = true)
    List<Feedback> findAllByServiceName();
}
