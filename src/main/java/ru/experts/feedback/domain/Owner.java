package ru.experts.feedback.domain;


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
@EqualsAndHashCode
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

    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime createDatetime;

    @Override
    @Transient
    public String toString(){
        return  "Id: " + id + "\n" +
                "Name: " + name + "\n" + "\n" +
                "CreateDatetime: " + createDatetime;
    }

    @Override
    @Transient
    public int hashCode() {
        return Objects.hash(id, name, createDatetime);
    }
}
