package com.inclusivamenteaba.api.entity.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inclusivamenteaba.api.entity.address.Address;
import com.inclusivamenteaba.api.entity.protocol.Protocol;
import com.inclusivamenteaba.api.entity.responsible.Responsible;
import com.inclusivamenteaba.api.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthday;

    @Column(unique = true)
    @CPF
    private String cpf;

    private String telephone;

    @Email
    private String email;

    @Column(name = "education_level")
    private String educationLevel;

    @Column(name = "medical_informations")
    private String medicalInformations;

    @Column(name = "medicines_in_use")
    private String medicinesInUse;

    @Column(name = "processing_information")
    private String processingInformation;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("client")
    private List<Responsible> responsible;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("client")
    private List<Protocol> protocols;

    public Client(
            String name,
            LocalDate birthday,
            Gender gender,
            String email,
            String cpf,
            String telephone,
            String educationLevel,
            String medicalInformations,
            String medicinesInUse,
            String processingInformation,
            String createdBy,
            LocalDateTime createdAt,
            Address address,
            List<Responsible> responsible
    ) {
        this.name = name;
        this.birthday = birthday;
        this.cpf = cpf;
        this.telephone = telephone;
        this.email = email;
        this.educationLevel = educationLevel;
        this.medicalInformations = medicalInformations;
        this.medicinesInUse = medicinesInUse;
        this.processingInformation = processingInformation;
        this.createdBy = createdBy;
        this.gender = gender;
        this.createdAt = createdAt;
        this.address = address;
        this.setResponsible(responsible);
    }

    public void setResponsible(List<Responsible> responsible) {
        responsible.forEach(r -> r.setClient(this));
        this.responsible = responsible;
    }

    public void updateData(Client client) {
        if(client.getName() != null) {
            this.setName(client.getName());
        }
        if(client.getBirthday() != null) {
            this.setBirthday(client.getBirthday());
        }
        if(client.getCpf() != null) {
            this.setCpf(client.getCpf());
        }
        if(client.getTelephone() != null) {
            this.setTelephone(client.getTelephone());
        }
        if(client.getEmail() != null) {
            this.setEmail(client.getEmail());
        }
        if(client.getEducationLevel() != null) {
            this.setEducationLevel(client.getEducationLevel());
        }
        if(client.getMedicalInformations() != null) {
            this.setMedicalInformations(client.getMedicalInformations());
        }
        if(client.getMedicinesInUse() != null) {
            this.setMedicinesInUse(client.getMedicinesInUse());
        }
        if(client.getProcessingInformation() != null) {
            this.setProcessingInformation(client.getProcessingInformation());
        }
        if(client.getUpdatedBy() != null) {
            this.setUpdatedBy(client.getUpdatedBy());
        }
        if(client.getGender() != null) {
            this.setGender(client.getGender());
        }
        if(client.getAddress() != null) {
            this.address.updateData(client.getAddress());
        }
        this.setUpdatedAt(LocalDateTime.now());
    }
}
