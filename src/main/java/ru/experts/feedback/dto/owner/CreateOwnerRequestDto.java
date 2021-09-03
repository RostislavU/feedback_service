package ru.experts.feedback.dto.owner;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOwnerRequestDto {
    @NotNull
    @Size(min = 3, max = 64)
    private String name;

    @NotNull
    @Max(32)
    private String hash;

    @Max(64)
    private String event;
}
