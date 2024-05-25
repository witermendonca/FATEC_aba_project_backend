package com.inclusivamenteaba.api.entity.responsible;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

public record ResponsibleResponse(
        @NotNull Long id,
        @NotBlank(message = "Nome é obrigatório") String name,
        @NotBlank(message = "CPF é obrigatório") @CPF String cpf,
        @NotBlank(message = "Email é obrigatório") @Email String email,
        @NotBlank String degreeOfKinship,
        @NotBlank(message = "Telefone é obrigatório") String telephone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public ResponsibleResponse(Responsible responsible) {
        this(responsible.getId(),
                responsible.getName(),
                responsible.getCpf(),
                responsible.getEmail(),
                responsible.getDegreeOfKinship(),
                responsible.getTelephone(),
                responsible.getCreatedAt(),
                responsible.getUpdatedAt());
    }
}
