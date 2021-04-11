package ru.experts.feedback.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

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

    @Column(name = "full_name", length=64)
    private String fullName;

    @Column(name = "email", length=64)
    private String email;

    @Column(name = "is_anonymously")
    private boolean isAnonymously;

    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feedback")
    private Set<Answer> answers;

    @ManyToOne
    @JoinColumn (name="customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn (name="template_id", referencedColumnName = "id")
    private Template template;

}
