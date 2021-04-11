package ru.experts.feedback.domain;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Embeddable
@EqualsAndHashCode
class OrderedQuestionKey implements Serializable {

    @NotNull
    @Column(name = "template_id", nullable = false)
    private UUID templateId;

    @NotNull
    @Column(name = "question_id", nullable = false)
    private UUID questionId;
}
