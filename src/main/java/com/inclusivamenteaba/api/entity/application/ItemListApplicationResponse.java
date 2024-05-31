package com.inclusivamenteaba.api.entity.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ItemListApplicationResponse(
        @NotBlank Long id,
        @NotNull Double positivePercentage,
        @NotNull Integer success,
        @NotNull Integer failure,
        @NotBlank String createdBy,
        LocalDateTime createdAt,
        Boolean aborted,
        String reasonAbortion
) {

    public ItemListApplicationResponse(Application application) {
        this(
                application.getId(),
                application.getPositivePercentage(),
                application.getSuccess(),
                application.getFailure(),
                application.getCreatedBy(),
                application.getCreatedAt(),
                application.getAborted(),
                application.getReasonAbortion()
        );
    }
}
