package com.inclusivamenteaba.api.entity.protocol;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ItemListProtocolResponse(
        @NotNull Long id,
        @NotBlank String name,
        @NotNull LocalDateTime createdAt,
        @NotBlank String createdBy
) {
    public ItemListProtocolResponse(Protocol protocol) {
        this(
                protocol.getId(),
                protocol.getName(),
                protocol.getCreatedAt(),
                protocol.getCreatedBy()
        );
    }
}
