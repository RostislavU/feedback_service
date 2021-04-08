package ru.experts.feedback.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    @Column(name = "value", length = 1024)
    private String value;

    @Column(name = "rating")
    private Short rating;

    @ManyToOne
    @JoinColumn(name = "feedback_id", referencedColumnName = "id")
    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

    public Answer() {
    }
}
