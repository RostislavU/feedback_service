package ru.experts.feedback.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;
import java.util.UUID;

/**
 * Обратная связь
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Embedded
    private CreationInfo creationInfo;

    @NotNull
    @Column(name = "template_id", nullable = false)
    private UUID templateId;

    @OneToMany(mappedBy = "feedback", cascade = CascadeType.ALL)
    private Set<Answer> answers;

    @Column(name = "is_read")
    private boolean isRead;

}
