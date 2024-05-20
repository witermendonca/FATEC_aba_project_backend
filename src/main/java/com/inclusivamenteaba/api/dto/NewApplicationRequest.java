package com.inclusivamenteaba.api.dto;

import com.inclusivamenteaba.api.entity.Application;
import com.inclusivamenteaba.api.entity.Attempt;
import com.inclusivamenteaba.api.entity.Protocol;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewApplicationRequest {

    @NotNull(message = "Percentual de sucesso é obrigatório")
    private Double positivePercentage;

    @NotNull(message = "Quantidade de tentativas com sucesso é obrigatório")
    private Integer success;

    @NotNull(message = "Quantidade de tentativas com falha é obrigatório")
    private Integer failure;

    @NotBlank(message = "Criador é obrigatório")
    private String createdBy;

    private Boolean aborted;

    private String reasonAbortion;

    @Valid
    @NotNull(message = "Tentativas é obrigatório")
    private List<NewAttemptRequest> attempts;

    @NotNull(message = "Id do protocolo é obrigatório")
    private Long protocolId;

    public Application toModel(Protocol protocol) {
        List<Attempt> attemptsEntity = convertToAttemptEntityList(attempts);
        return new Application(
                positivePercentage,
                success,
                failure,
                createdBy,
                aborted,
                reasonAbortion,
                attemptsEntity,
                protocol
        );
    }

    private List<Attempt> convertToAttemptEntityList(List<NewAttemptRequest> attemptRequestList) {
        List<Attempt> attemptList = new ArrayList<>();
        for (NewAttemptRequest attemptRequest : attemptRequestList) {
            Attempt attempt = new Attempt(attemptRequest);
            attemptList.add(attempt);
        }
        return attemptList;
    }
}
