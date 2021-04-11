package ru.experts.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Сущность для изменения/создания шаблона
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditTemplateRequest {
    private UUID ownerId;
    private String name;
    private String comment;
    private boolean is_available;
}
