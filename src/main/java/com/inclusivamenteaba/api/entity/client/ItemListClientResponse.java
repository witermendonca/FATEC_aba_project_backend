package com.inclusivamenteaba.api.entity.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ItemListClientResponse(
        @NotNull Long id,
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @NotBlank(message = "Email é obrigatório")
        @Email
        String email,
        @NotNull
        LocalDate birthday
) {
        public ItemListClientResponse(Client client) {
                this(
                        client.getId(),
                        client.getName(),
                        client.getEmail(),
                        client.getBirthday()
                );
        }
}
