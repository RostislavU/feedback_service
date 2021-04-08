package ru.experts.feedback.domain;


import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length = 16)
    private String name;

    @Column(name = "hash", length = 32)
    private String hash;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Feedback> feedbacks;
}
