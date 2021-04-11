package ru.experts.feedback.domain;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class CreationInfo {
    private String creator_name;
    private String creator_email;
    private LocalDateTime create_date;

    public CreationInfo(String name, String email){
        creator_name = name;
        creator_email = email;
        create_date = LocalDateTime.now();
    }

}
