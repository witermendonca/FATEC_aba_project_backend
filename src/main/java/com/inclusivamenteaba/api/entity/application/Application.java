package com.inclusivamenteaba.api.entity.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inclusivamenteaba.api.entity.attempt.Attempt;
import com.inclusivamenteaba.api.entity.protocol.Protocol;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "positive_percentage")
    private Double positivePercentage;

    private Integer success;

    private Integer failure;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "created_by")
    private String createdBy;

    private Boolean aborted;

    @Column(name = "reason_abortion")
    private String reasonAbortion;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("application")
    private List<Attempt> attempts;

    @ManyToOne
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;

    public Application(Double positivePercentage, Integer success, Integer failure, String created_by, Boolean aborted, String reasonAbortion, List<Attempt> attempts, Protocol protocol) {
        this.positivePercentage = positivePercentage;
        this.success = success;
        this.failure = failure;
        this.createdBy = created_by;
        this.aborted = aborted;
        this.reasonAbortion = reasonAbortion;
        this.protocol = protocol;
        setAttempts(attempts);
    }

    public void setAttempts(List<Attempt> attempts) {
        attempts.forEach(a -> a.setApplication(this));
        this.attempts = attempts;
    }
}
