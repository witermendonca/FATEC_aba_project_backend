package com.inclusivamenteaba.api.entity.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inclusivamenteaba.api.entity.address.Address;
import com.inclusivamenteaba.api.entity.protocol.ItemListProtocolResponse;
import com.inclusivamenteaba.api.entity.responsible.ResponsibleResponse;
import com.inclusivamenteaba.api.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record ClientDetailsResponse(
        Long id,
        String name,
        @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthday,
        String cpf,
        String telephone,
        String email,
        String educationLevel,
        String medicalInformations,
        String medicinesInUse,
        String processingInformation,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS") LocalDateTime createdAt,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS") LocalDateTime updatedAt,
        String createdBy,
        String updatedBy,
        Gender gender,
        Address address,
        List<ResponsibleResponse> responsible,
        List<ItemListProtocolResponse> protocols
) {
    public ClientDetailsResponse(Client client) {
        this(
                client.getId(),
                client.getName(),
                client.getBirthday(),
                client.getCpf(),
                client.getTelephone(),
                client.getEmail(),
                client.getEducationLevel(),
                client.getMedicalInformations(),
                client.getMedicinesInUse(),
                client.getProcessingInformation(),
                client.getCreatedAt(),
                client.getUpdatedAt(),
                client.getCreatedBy(),
                client.getUpdatedBy(),
                client.getGender(),
                client.getAddress(),
                client.getResponsible().stream().map(ResponsibleResponse::new).collect(Collectors.toList()),
                client.getProtocols().stream().map(ItemListProtocolResponse::new).collect(Collectors.toList())
        );
    }
}
