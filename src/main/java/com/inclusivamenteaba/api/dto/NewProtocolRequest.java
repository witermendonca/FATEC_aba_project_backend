package com.inclusivamenteaba.api.dto;

import com.inclusivamenteaba.api.entity.Client;
import com.inclusivamenteaba.api.entity.Protocol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewProtocolRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "Criador é obrigatório")
    private String createdBy;

    @NotNull(message = "Id do cliente é obrigatório")
    private Long idClient;

    public Protocol toModel(Client client) {
        return new Protocol(name, createdBy, client);
    }
}
