package ru.experts.feedback.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Владелец формы обратной связи
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(name = "name", length = 16, nullable = false)
    private String name;

    @NotNull
    @Column(name = "hash", length = 32, nullable = false)
    private String hash;

    @OneToMany(mappedBy = "owner")
    private Set<Template> templates;

    @Column(name = "event", length = 32)
    private String event;
}
