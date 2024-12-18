package com.inclusivamenteaba.api.entity.protocol;

import com.inclusivamenteaba.api.entity.application.ItemListApplicationResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record ProtocolResponse(
        @NotNull Long id,
        @NotBlank String name,
        @NotNull LocalDateTime createdAt,
        @NotBlank String createdBy,
        @NotNull long clientId,
        List<ItemListApplicationResponse> applications
) {
    public ProtocolResponse(Protocol protocol) {
        this(
                protocol.getId(),
                protocol.getName(),
                protocol.getCreatedAt(),
                protocol.getCreatedBy(),
                protocol.getClient().getId(),
                protocol.getApplications().stream()
                        .map(ItemListApplicationResponse::new)
                        .collect(Collectors.toList())
        );
    }
}
