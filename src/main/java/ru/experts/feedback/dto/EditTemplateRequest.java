package ru.experts.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сущность для изменения/создания шаблона
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditTemplateRequest {

    private String name;
    private String creator;

}
