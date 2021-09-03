package ru.experts.feedback.domain;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Шаблон с вопросами
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "comment", length = 1024)
    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime createDatetime;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "is_available")
    private boolean isAvailable;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    @OneToMany(mappedBy = "template")
    private Set<OrderedQuestion> orderedQuestions;

    @Override
    @Transient
    public String toString() {
        return "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Comment: " + comment + "\n" +
                "CreateDatetime: " + createDatetime;
    }

    @Override
    @Transient
    public int hashCode() {
        return Objects.hash(id, createDatetime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Template)) return false;
        Template template = (Template) o;
        return isDeleted == template.isDeleted && isAvailable == template.isAvailable && id.equals(template.id) && name.equals(template.name) && Objects.equals(comment, template.comment) && createDatetime.equals(template.createDatetime) && owner.equals(template.owner) && Objects.equals(orderedQuestions, template.orderedQuestions);
    }
}
