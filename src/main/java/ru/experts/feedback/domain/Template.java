package ru.experts.feedback.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "create_datetime")
    @Temporal(TemporalType.DATE)
    private Date createDatetime;

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

    @ManyToOne
    @JoinColumn (name="template_id", referencedColumnName = "id")
    private Service serviceId;


    public Template() {
    }

    public void changeDeleted() {
        isDeleted = !isDeleted;
    }

    public boolean getIsDeleted(){
        return isDeleted;
    }
}
