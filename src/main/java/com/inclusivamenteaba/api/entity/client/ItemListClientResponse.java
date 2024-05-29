package com.inclusivamenteaba.api.entity.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemListClientResponse(
        @NotNull Long id,
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @NotBlank(message = "Email é obrigatório")
        @Email
        String email
) {
        public ItemListClientResponse(Client client) {
                this(
                        client.getId(),
                        client.getName(),
                        client.getEmail()
                );
        }
}
