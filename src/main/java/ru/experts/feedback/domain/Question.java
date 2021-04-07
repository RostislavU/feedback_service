package ru.experts.feedback.domain;

import ru.experts.feedback.enums.QuestionType;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "text", length = 1024)
    private String text;

    private QuestionType type;

    @Column(name = "struct", length = 1024)
    private String struct;

    private boolean hidden;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Set<Answer> answers;

    @ManyToMany(mappedBy = "questions")
    private Set<Template> template;
}
