package com.inclusivamenteaba.api.entity.application;

import com.inclusivamenteaba.api.entity.attempt.Attempt;
import com.inclusivamenteaba.api.entity.attempt.NewAttemptRequest;
import com.inclusivamenteaba.api.entity.protocol.Protocol;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public record NewApplicationRequest(
        @NotNull(message = "Percentual de sucesso é obrigatório")
        Double positivePercentage,
        @NotNull(message = "Quantidade de tentativas com sucesso é obrigatório")
        Integer success,
        @NotNull(message = "Quantidade de tentativas com falha é obrigatório")
        Integer failure,
        @NotBlank(message = "Criador é obrigatório")
        String createdBy,
        Boolean aborted,
        String reasonAbortion,
        @Valid @NotNull(message = "Tentativas é obrigatório")
        List<NewAttemptRequest> attempts,
        @NotNull(message = "Id do protocolo é obrigatório")
        Long protocolId
) {
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
        return attemptRequestList.stream()
                .map(Attempt::new)
                .collect(Collectors.toList());
    }
}
