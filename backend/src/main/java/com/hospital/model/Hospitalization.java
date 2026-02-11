package com.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "hospitalizations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hospitalization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    
    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;
    
    @Column(name = "admission_date", nullable = false)
    private LocalDateTime admissionDate;
    
    @Column(name = "discharge_date")
    private LocalDateTime dischargeDate;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HospitalizationStatus status = HospitalizationStatus.ATIVA;
    
    @Column(name = "admission_reason", columnDefinition = "TEXT")
    private String admissionReason;
    
    @Column(columnDefinition = "TEXT")
    private String diagnosis;
    
    @Column(name = "discharge_summary", columnDefinition = "TEXT")
    private String dischargeSummary;
    
    @Column(name = "discharge_prescription", columnDefinition = "TEXT")
    private String dischargePrescription;
    
    @Enumerated(EnumType.STRING)
    private HospitalizationType type;
    
    @Column(name = "insurance_authorization")
    private String insuranceAuthorization;
    
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
    
    public enum HospitalizationStatus {
        ATIVA, ALTA, TRANSFERIDO, OBITO
    }
    
    public enum HospitalizationType {
        CLINICA, CIRURGICA, EMERGENCIA, UTI, ONCOLOGIA
    }
}
