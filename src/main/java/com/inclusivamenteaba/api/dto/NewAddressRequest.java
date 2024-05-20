package com.inclusivamenteaba.api.dto;

import com.inclusivamenteaba.api.entity.Address;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewAddressRequest {

    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    @NotBlank(message = "Rua é obrigatório")
    private String street;

    @NotNull(message = "Número é obrigatório")
    private int addressNumber;

    private String complement;

    @NotBlank(message = "Bairro é obrigatório")
    private String neighborhood;

    @NotBlank(message = "Cidade é obrigatório")
    private String city;

    @NotBlank(message = "Estado é obrigatório")
    private String state;

    public Address toModel() {
        return new Address(cep, street, addressNumber, complement, neighborhood, city, state);
    }
}