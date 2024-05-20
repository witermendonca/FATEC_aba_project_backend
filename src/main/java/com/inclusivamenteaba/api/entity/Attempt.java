package com.inclusivamenteaba.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inclusivamenteaba.api.dto.NewAttemptRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "attempts")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attempt_number")
    private Integer attemptNumber;

    private String help;

    private String comments;

    private Boolean result;

    @ManyToOne
    @JoinColumn(name = "application_id")
    @JsonIgnoreProperties("attempts")
    private Application application;

    public Attempt(NewAttemptRequest attempt) {
        this.attemptNumber = attempt.getAttemptNumber();
        this.help = attempt.getHelp();
        this.comments = attempt.getComments();
        this.result = attempt.getResult();
    }
}
