package com.inclusivamenteaba.api.dto;

import com.inclusivamenteaba.api.entity.Application;
import com.inclusivamenteaba.api.entity.Attempt;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {
    @NotBlank
    private Long id;

    @NotNull
    private Double positivePercentage;

    @NotNull
    private Integer success;

    @NotNull
    private Integer failure;

    @NotBlank
    private String createdBy;

    private LocalDateTime createdAt;

    private Boolean aborted;

    private String reasonAbortion;

    @Valid
    @NotNull
    private List<AttemptResponse> attempts;

    public ApplicationResponse(Application application) {
        this.id = application.getId();
        this.positivePercentage = application.getPositivePercentage();
        this.success = application.getSuccess();
        this.failure = application.getFailure();
        this.createdBy = application.getCreatedBy();
        this.createdAt = application.getCreatedAt();
        this.aborted = application.getAborted();
        this.reasonAbortion = application.getReasonAbortion();
        this.attempts = application.getAttempts().stream().map(AttemptResponse::new).collect(Collectors.toList());
    }
}
