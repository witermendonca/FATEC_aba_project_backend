package com.inclusivamenteaba.api.entity.attempt;

import jakarta.validation.constraints.NotNull;

public record NewAttemptRequest(
        @NotNull(message = "Número da tentaiva é obrigatório")
        Integer attemptNumber,
        String help,
        String comments,
        @NotNull(message = "Resultado é obrigatório")
        Boolean result
) {
}
