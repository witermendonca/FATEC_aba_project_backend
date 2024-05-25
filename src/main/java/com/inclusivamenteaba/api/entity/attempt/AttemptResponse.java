package com.inclusivamenteaba.api.entity.attempt;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AttemptResponse(
        @NotBlank Long id,
        @NotNull Integer attemptNumber,
        String help,
        String comments,
        @NotNull Boolean result
) {
    public AttemptResponse(Attempt attempt) {
        this(
                attempt.getId(),
                attempt.getAttemptNumber(),
                attempt.getHelp(),
                attempt.getComments(),
                attempt.getResult()
        );
    }
}
