package com.inclusivamenteaba.api.dto;

import com.inclusivamenteaba.api.entity.Protocol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProtocolResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String name;

    @NotNull
    private LocalDateTime createdAt;

    @NotBlank
    private String createdBy;

    @NotNull
    private List<ApplicationResponse> applications;

    public ProtocolResponse(Protocol protocol) {
        this.id = protocol.getId();
        this.name = protocol.getName();
        this.createdAt = protocol.getCreatedAt();
        this.createdBy = protocol.getCreatedBy();
        this.applications = protocol.getApplications().stream().map(ApplicationResponse::new).collect(Collectors.toList());
    }
}
