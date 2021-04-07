package ru.experts.feedback.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
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
    @Temporal(TemporalType.DATE)
    private Date createDatetime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feedback")
    private Set<Answer> answers;

    @ManyToOne
    @JoinColumn (name="service_id", referencedColumnName = "id")
    private Service service;

    @ManyToOne
    @JoinColumn (name="template_id", referencedColumnName = "id")
    private Template template;

}
