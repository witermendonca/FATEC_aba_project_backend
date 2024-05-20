package com.inclusivamenteaba.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "protocol")
public class Protocol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "created_by")
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties("protocol")
    private Client client;

    @OneToMany(mappedBy = "protocol", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("protocol")
    private List<Application> applications;

    public Protocol(String name, String createdBy, Client client) {
        this.name = name;
        this.createdBy = createdBy;
        this.client = client;
    }
}
