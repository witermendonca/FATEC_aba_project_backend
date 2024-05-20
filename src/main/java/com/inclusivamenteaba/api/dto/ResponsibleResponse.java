package com.inclusivamenteaba.api.dto;

import com.inclusivamenteaba.api.entity.Responsible;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsibleResponse {

    @NotNull
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "CPF é obrigatório")
    @CPF
    private String cpf;

    @NotBlank(message = "Email é obrigatório")
    @Email
    private String email;

    @NotBlank
    private String degreeOfKinship;

    @NotBlank(message = "Telefone é obrigatório")
    private String telephone;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ResponsibleResponse(Responsible responsible) {
        this.id = responsible.getId();
        this.name = responsible.getName();
        this.cpf = responsible.getCpf();
        this.email = responsible.getEmail();
        this.degreeOfKinship = responsible.getDegreeOfKinship();
        this.telephone = responsible.getTelephone();
        this.createdAt = responsible.getCreatedAt();
        this.updatedAt = responsible.getUpdatedAt();
    }
}
