package com.inclusivamenteaba.api.entity.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewAddressRequest(
        @NotBlank(message = "CEP é obrigatório")
        String cep,
        @NotBlank(message = "Rua é obrigatório")
        String street,
        @NotNull(message = "Número é obrigatório")
        Integer addressNumber,
        String complement,
        @NotBlank(message = "Bairro é obrigatório")
        String neighborhood,
        @NotBlank(message = "Cidade é obrigatório")
        String city,
        @NotBlank(message = "Estado é obrigatório")
        String state
) {
    public Address toModel() {
        return new Address(cep, street, addressNumber, complement, neighborhood, city, state);
    }
}
