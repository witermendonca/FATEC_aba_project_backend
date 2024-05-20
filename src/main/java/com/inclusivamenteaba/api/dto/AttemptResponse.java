package com.inclusivamenteaba.api.dto;

import com.inclusivamenteaba.api.entity.Attempt;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttemptResponse {
    @NotBlank
    private Long id;

    @NotNull
    private Integer attemptNumber;

    private String help;

    private String comments;

    @NotNull
    private Boolean result;

    public AttemptResponse(Attempt attempt) {
        this.id = attempt.getId();
        this.attemptNumber = attempt.getAttemptNumber();
        this.help = attempt.getHelp();
        this.comments = attempt.getComments();
        this.result = attempt.getResult();
    }
}
