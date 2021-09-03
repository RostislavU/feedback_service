package ru.experts.feedback.dto.answer;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditAnswerRequestDto {
    @NotNull
    private UUID question_id;
    @NotNull
    private String value;
    private Short rating;

}
