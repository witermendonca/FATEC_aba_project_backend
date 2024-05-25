package com.inclusivamenteaba.api.entity.application;


import com.inclusivamenteaba.api.entity.attempt.AttemptResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record ApplicationResponse(
        @NotBlank Long id,
        @NotNull Double positivePercentage,
        @NotNull Integer success,
        @NotNull Integer failure,
        @NotBlank String createdBy,
        LocalDateTime createdAt,
        Boolean aborted,
        String reasonAbortion,
        @Valid @NotNull List<AttemptResponse> attempts
) {
    public ApplicationResponse(Application application) {
        this(
                application.getId(),
                application.getPositivePercentage(),
                application.getSuccess(),
                application.getFailure(),
                application.getCreatedBy(),
                application.getCreatedAt(),
                application.getAborted(),
                application.getReasonAbortion(),
                application.getAttempts().stream()
                        .map(AttemptResponse::new)
                        .collect(Collectors.toList())
        );
    }
}