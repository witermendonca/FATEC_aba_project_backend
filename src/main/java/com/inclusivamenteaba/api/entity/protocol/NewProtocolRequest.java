package com.inclusivamenteaba.api.entity.protocol;

import com.inclusivamenteaba.api.entity.client.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewProtocolRequest(
        @NotBlank(message = "Nome é obrigatório")
        String name,
        @NotBlank(message = "Criador é obrigatório")
        String createdBy,
        @NotNull(message = "Id do cliente é obrigatório")
        Long idClient
) {
    public Protocol toModel(Client client) {
        return new Protocol(name, createdBy, client);
    }
}