package com.inclusivamenteaba.api.entity.client;

import com.inclusivamenteaba.api.entity.address.Address;
import com.inclusivamenteaba.api.entity.address.NewAddressRequest;
import com.inclusivamenteaba.api.entity.responsible.NewResponsibleClientRequest;
import com.inclusivamenteaba.api.entity.responsible.Responsible;
import com.inclusivamenteaba.api.enums.Gender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ClientRequest(
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @NotNull(message = "Data de nascimento é obrigatório")
        LocalDate birthday,
        @NotNull(message = "Genero é obrigatório")
        Gender gender,
        @NotBlank(message = "CPF é obrigatório")
        @CPF
        String cpf,
        @NotBlank(message = "Telefone é obrigatório")
        String telephone,
        @NotBlank(message = "Email é obrigatório")
        @Email
        String email,
        String educationLevel,
        String medicalInformations,
        String medicinesInUse,
        String processingInformation,
        @NotNull(message = "Endereço é obrigatório")
        @Valid
        NewAddressRequest address,
        String createdBy,
        @Valid
        List<NewResponsibleClientRequest> responsible
) {
        public Client toModel() {
                LocalDateTime now = LocalDateTime.now();
                Address addressEntity = address.toModel();
                List<Responsible> responsibleEntity = responsible.stream()
                        .map(NewResponsibleClientRequest::toModel)
                        .toList();
                return new Client(
                        name, birthday, gender, email, cpf, telephone, educationLevel, medicalInformations,
                        medicinesInUse, processingInformation, createdBy, now, addressEntity, responsibleEntity);
        }
}
