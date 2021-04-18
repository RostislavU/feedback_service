package ru.experts.feedback.dto.template;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Сущность для изменения/создания шаблона
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditTemplateRequestDto {
    @NotNull
    private UUID ownerId;
    @NotNull
    private String name;
    private String comment;
    private boolean isAvailable;
}
