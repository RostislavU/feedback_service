package ru.experts.feedback.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class CreationInfo {
    private String creator_name;
    private String creator_email;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_date;

    public CreationInfo(String name, String email){
        creator_name = name;
        creator_email = email;
        create_date = LocalDateTime.now();
    }
    @Override
    public String toString(){
        return "Creator:" + creator_name + "\n" +
                "Time"  + create_date;
    }

}
