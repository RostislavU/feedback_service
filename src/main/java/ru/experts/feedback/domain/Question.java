package ru.experts.feedback.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.experts.feedback.enums.QuestionType;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(name = "text", length = 1024)
    private String text;

    @NotNull
    private QuestionType type;

    @Column(name = "struct", length = 1024)
    private String struct;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    @Transient
    private Set<Answer> answers;

    @ManyToMany(mappedBy = "questions")
    @Transient
    private Set<Template> template;
}
