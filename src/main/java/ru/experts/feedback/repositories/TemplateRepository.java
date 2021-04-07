package ru.experts.feedback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.experts.feedback.domain.Template;

import java.util.UUID;

@Repository
public interface TemplateRepository extends JpaRepository<Template, UUID> {
}
