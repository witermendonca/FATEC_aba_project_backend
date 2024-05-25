package com.inclusivamenteaba.api.entity.responsible;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

public record NewResponsibleRequest(
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @NotBlank(message = "CPF é obrigatório")
        @CPF
        String cpf,
        @NotBlank(message = "Email é obrigatório")
        @Email
        String email,
        @NotBlank
        String degreeOfKinship,
        @NotBlank(message = "Telefone é obrigatório")
        String telephone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public Responsible toModel() {
        LocalDateTime now = LocalDateTime.now();
        return new Responsible(
                name,
                cpf,
                email,
                degreeOfKinship,
                telephone,
                createdAt != null ? createdAt : now,
                updatedAt
        );
    }
}
