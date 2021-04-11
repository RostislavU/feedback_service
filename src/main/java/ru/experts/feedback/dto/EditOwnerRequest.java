package ru.experts.feedback.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditOwnerRequest {
    @NotNull
    private String name;
    @NotNull
    private String hash;
    private String event;
}
