package ru.experts.feedback.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length=64)
    private String name;

    @Column(name = "create_datetime")
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

    public void setDeleted() {
        isDeleted = true;
    }


    public boolean getIsDeleted(){
        return isDeleted;
    }
}
