package ru.experts.feedback.domain;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length=64)
    private String name;

    @Column(name = "create_datetime")
    @Temporal(TemporalType.DATE)
    private LocalDateTime createDatetime;

    @Column(name = "creator", length=64)
    private String creator;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "templates_questions",
            joinColumns = @JoinColumn(name = "question_id") ,
            inverseJoinColumns = @JoinColumn(name = "template_id")
    )
    private Set<Question> questions;

    public Template() {
    }

    public void setDeleted() {
        isDeleted = true;
    }


    public boolean getIsDeleted(){
        return isDeleted;
    }
}
