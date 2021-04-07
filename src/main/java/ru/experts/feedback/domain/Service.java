package ru.experts.feedback.domain;


import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length = 16)
    private String name;

    @Column(name = "hash", length = 32)
    private String hash;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private Set<Feedback> feedbacks;
}
