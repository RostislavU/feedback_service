package ru.experts.feedback.dto.template;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.Ordered;
import ru.experts.feedback.domain.OrderedQuestion;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemplateDto {
    @NotNull
    private UUID id;
    @NotNull
    private String name;
    private String comment;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDateTime;
    private Set<OrderedQuestion> orderedQuestions;
}
