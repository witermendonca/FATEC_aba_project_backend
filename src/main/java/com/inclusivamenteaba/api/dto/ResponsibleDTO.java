package com.inclusivamenteaba.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class ResponsibleDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "CPF é obrigatório")
    @CPF
    private String cpf;

    @NotBlank(message = "Email é obrigatório")
    @Email
    private String email;

    @NotBlank
    private String degree_of_kinship;

    @NotBlank(message = "Telefone é obrigatório")
    private String telephone;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

}
