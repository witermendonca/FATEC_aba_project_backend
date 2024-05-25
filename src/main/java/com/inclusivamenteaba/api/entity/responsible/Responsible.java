package com.inclusivamenteaba.api.entity.responsible;

import com.inclusivamenteaba.api.entity.client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@Entity
@Table(name = "responsible")
@NoArgsConstructor
@Data
@AllArgsConstructor
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
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Responsible(String name, String cpf, String email, String degreeOfKinship, String telephone, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.degreeOfKinship = degreeOfKinship;
        this.telephone = telephone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
