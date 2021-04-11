package ru.experts.feedback.entity;

import ru.experts.feedback.enums.Service;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="first_name", length=128)
    private String firstName;

    @Column(name="last_name", length=128)
    private String lastName;

    @Column(name="email", length=128)
    private String email;

    @Column(name="is_anonymously")
    private boolean isAnonymously;

    //private Service service;

    @Column(name="text", length=4096)
    private String text;

    //    @Column(name = "create_datetime")
    //    @Temporal(TemporalType.DATE)
    //    private Date createDatetime;
}
