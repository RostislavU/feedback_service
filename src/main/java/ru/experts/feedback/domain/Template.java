package ru.experts.feedback.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * Шаблон с вопросами
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(name = "name", length=64, nullable = false)
    private String name;

    @Column(name = "comment", length = 1024)
    private String comment;

    @NotNull
    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime createDatetime;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "is_available")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    @OneToMany(mappedBy = "template")
    private Set<OrderedQuestion> orderedQuestions;


    public void setDeleted() {
        isDeleted = true;
    }

    public void setPrivate() {
        isAvailable = false;
    }

    public void setAvailable() {
        isAvailable = true;
    }

    public boolean getIsDeleted(){
        return isDeleted;
    }
}
