package ru.experts.feedback.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * Владелец формы обратной связи
 */
@Data
@Entity
@Builder
@AllArgsConstructor
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

    public Owner(){
    }
}
