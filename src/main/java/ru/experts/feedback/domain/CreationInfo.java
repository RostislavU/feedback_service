package ru.experts.feedback.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class CreationInfo {
    private String creatorName;
    private String creatorEmail;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    public CreationInfo(String name, String email){
        creatorName = name;
        creatorEmail = email;
        createDate = LocalDateTime.now();
    }
    @Override
    public String toString(){
        return "Creator:" + creatorName + "\n" +
                "Time"  + createDate;
    }

}
