package com.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "oncology_treatments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OncologyTreatment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;
    
    @Column(name = "end_date")
    private LocalDateTime endDate;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TreatmentType type;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TreatmentStatus status = TreatmentStatus.EM_ANDAMENTO;
    
    @Column(name = "cancer_type")
    private String cancerType;
    
    @Column(name = "cancer_stage")
    private String cancerStage;
    
    @Column(name = "treatment_protocol", columnDefinition = "TEXT")
    private String treatmentProtocol;
    
    @Column(name = "total_sessions")
    private Integer totalSessions;
    
    @Column(name = "completed_sessions")
    private Integer completedSessions = 0;
    
    @Column(columnDefinition = "TEXT")
    private String medications;
    
    @Column(name = "side_effects", columnDefinition = "TEXT")
    private String sideEffects;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    @Column(name = "next_session_date")
    private LocalDateTime nextSessionDate;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    public enum TreatmentType {
        QUIMIOTERAPIA, RADIOTERAPIA, IMUNOTERAPIA, HORMONIOTERAPIA, CIRURGIA, COMBINADO
    }
    
    public enum TreatmentStatus {
        EM_ANDAMENTO, CONCLUIDO, SUSPENSO, CANCELADO
    }
}
