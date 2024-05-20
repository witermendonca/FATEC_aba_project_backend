package com.inclusivamenteaba.api.entity;

import com.inclusivamenteaba.api.dto.NewResponsibleRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Entity
@Table(name = "responsible")
@NoArgsConstructor
@Data
public class Responsible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CPF
    private String cpf;

    @Email
    private String email;

    @Column(name = "degree_of_kinship")
    private String degreeOfKinship;

    private String telephone;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Responsible(NewResponsibleRequest responsible) {
        this.name = responsible.getName();
        this.cpf = responsible.getCpf();
        this.email = responsible.getEmail();
        this.degreeOfKinship = responsible.getDegreeOfKinship();
        this.telephone = responsible.getTelephone();
    }

    public void updateData(Responsible updatedResponsible) {
        if(updatedResponsible.getName() != null) {
            this.setName(updatedResponsible.getName());
        }
        if(updatedResponsible.getCpf() != null) {
            this.setCpf(updatedResponsible.getCpf());
        }
        if(updatedResponsible.getEmail() != null) {
            this.setEmail(updatedResponsible.getEmail());
        }
        if(updatedResponsible.getDegreeOfKinship() != null) {
            this.setDegreeOfKinship(updatedResponsible.getDegreeOfKinship());
        }
        if(updatedResponsible.getTelephone() != null) {
            this.setTelephone(updatedResponsible.getTelephone());
        }
        this.setUpdatedAt(LocalDateTime.now());
    }
}
