package com.inclusivamenteaba.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewAttemptRequest {

    @NotNull(message = "Número da tentaiva é obrigatório")
    private Integer attemptNumber;

    private String help;

    private String comments;

    @NotNull(message = "Resultado é obrigatório")
    private Boolean result;
}

