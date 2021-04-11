package ru.experts.feedback.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

/**
 * Связывающая таблица, содержащаяя данные сортировки вопросов в шаблоне
 */
@Data
@Entity
public class OrderedQuestion {

    @EmbeddedId
    private OrderedQuestionKey id;

    @ManyToOne
    @MapsId("templateId")
    @JoinColumn(name = "template_id")
    private Template template;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;

    /**
     * Назначать кратное 100
     */
    @NotNull
    @Column(name = "view_order", nullable = false)
    public int view_order;
}
