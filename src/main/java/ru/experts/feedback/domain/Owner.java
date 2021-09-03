package ru.experts.feedback.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Владелец формы обратной связи
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length = 64, nullable = false, unique = true)
    private String name;

    @Column(name = "hash", length = 32, nullable = false)
    private String hash;

    @OneToMany(mappedBy = "owner")
    private Set<Template> templates;

    @Column(name = "event", length = 64)
    private String event;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime createDatetime;

    @Override
    @Transient
    public String toString() {
        return "Id: " + id + "\n" +
                "Name: " + name + "\n" + "\n" +
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
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return id.equals(owner.id) && Objects.equals(name, owner.name) && hash.equals(owner.hash) && Objects.equals(templates, owner.templates) && Objects.equals(event, owner.event) && createDatetime.equals(owner.createDatetime);
    }
}
