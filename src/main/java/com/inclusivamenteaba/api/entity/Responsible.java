package com.inclusivamenteaba.api.entity;

import com.inclusivamenteaba.api.dto.ResponsibleDTO;
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

    private String degree_of_kinship;

    private String telephone;

    private LocalDateTime created_at = LocalDateTime.now();

    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Responsible(ResponsibleDTO responsibleDTO) {
        this.name = responsibleDTO.getName();
        this.cpf = responsibleDTO.getCpf();
        this.email = responsibleDTO.getEmail();
        this.degree_of_kinship = responsibleDTO.getDegree_of_kinship();
        this.telephone = responsibleDTO.getTelephone();
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
        if(updatedResponsible.getDegree_of_kinship() != null) {
            this.setDegree_of_kinship(updatedResponsible.getDegree_of_kinship());
        }
        if(updatedResponsible.getTelephone() != null) {
            this.setTelephone(updatedResponsible.getTelephone());
        }
        this.setUpdated_at(LocalDateTime.now());
    }
}
