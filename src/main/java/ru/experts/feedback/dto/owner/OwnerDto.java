package ru.experts.feedback.dto.owner;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.experts.feedback.dto.template.TemplateDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {
    @NotNull
    private UUID id;
    @NotNull
    private String name;
    private Set<TemplateDto> templateDtoSet;
    private String event;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDatetime;
}
