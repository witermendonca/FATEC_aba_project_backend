package com.inclusivamenteaba.api.dto;
import com.inclusivamenteaba.api.entity.Address;
import com.inclusivamenteaba.api.entity.Client;
import com.inclusivamenteaba.api.entity.Responsible;
import com.inclusivamenteaba.api.enums.Gender;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotNull(message = "Data de nascimento é obrigatório")
    private LocalDate birthday;

    @NotNull(message = "Genero é obrigatório")
    private Gender gender;

    @NotBlank(message = "CPF é obrigatório")
    @CPF
    private String cpf;

    @NotBlank(message = "Telefone é obrigatório")
    private String telephone;

    @NotBlank(message = "Email é obrigatório")
    @Email
    private String email;

    private String education_level;

    private String medical_informations;

    private String medicines_in_use;

    private String processing_information;

    @NotNull(message = "Endereço é obrigatório")
    @Valid
    private AddressDTO address;

    private String created_by;

    @Valid
    @NotNull(message = "Responsável é obrigatório")
    private List<ResponsibleDTO> responsible;

    public Client toModel() {
        Address addressEntity = address.toModel();
        List<Responsible> responsibleEntity = convertToResponsibleEntityList(responsible);
        return new Client(name, birthday, gender, email, cpf, telephone, education_level, medical_informations,
                medicines_in_use, processing_information, created_by, addressEntity, responsibleEntity);
    }

    private List<Responsible> convertToResponsibleEntityList(List<ResponsibleDTO> responsibleDTOList) {
        List<Responsible> responsibleList = new ArrayList<>();
        for (ResponsibleDTO responsibleDTO : responsibleDTOList) {
            Responsible responsible = new Responsible(responsibleDTO);
            responsibleList.add(responsible);
        }
        return responsibleList;
    }
}
