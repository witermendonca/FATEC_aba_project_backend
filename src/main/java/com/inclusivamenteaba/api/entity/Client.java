package com.inclusivamenteaba.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    private String education_level;

    private String medical_informations;

    private String medicines_in_use;

    private String processing_information;

    private LocalDateTime created_at = LocalDateTime.now();

    private LocalDateTime updated_at;

    private String created_by;

    private String updated_by;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("client")
    private List<Responsible> responsible;

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
            Address address,
            List<Responsible> responsible
    ) {
        this.name = name;
        this.birthday = birthday;
        this.cpf = cpf;
        this.telephone = telephone;
        this.email = email;
        this.education_level = educationLevel;
        this.medical_informations = medicalInformations;
        this.medicines_in_use = medicinesInUse;
        this.processing_information = processingInformation;
        this.created_by = createdBy;
        this.gender = gender;
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
        if(client.getEducation_level() != null) {
            this.setEducation_level(client.getEducation_level());
        }
        if(client.getMedical_informations() != null) {
            this.setMedical_informations(client.getMedical_informations());
        }
        if(client.getMedicines_in_use() != null) {
            this.setMedicines_in_use(client.getMedicines_in_use());
        }
        if(client.getProcessing_information() != null) {
            this.setProcessing_information(client.getProcessing_information());
        }
        if(client.getUpdated_by() != null) {
            this.setUpdated_by(client.getUpdated_by());
        }
        if(client.getGender() != null) {
            this.setGender(client.getGender());
        }
        if(client.getAddress() != null) {
            this.address.updateData(client.getAddress());
        }
        this.setUpdated_at(LocalDateTime.now());
    }
}
