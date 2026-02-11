package com.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "medical_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecord {
    
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
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
    
    @Column(name = "record_date", nullable = false)
    private LocalDateTime recordDate;
    
    @Column(columnDefinition = "TEXT")
    private String complaint;
    
    @Column(name = "physical_exam", columnDefinition = "TEXT")
    private String physicalExam;
    
    @Column(columnDefinition = "TEXT")
    private String diagnosis;
    
    @Column(columnDefinition = "TEXT")
    private String treatment;
    
    @Column(columnDefinition = "TEXT")
    private String prescription;
    
    @Column(name = "lab_tests", columnDefinition = "TEXT")
    private String labTests;
    
    @Column(name = "imaging_exams", columnDefinition = "TEXT")
    private String imagingExams;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
    // Sinais Vitais
    @Column(name = "blood_pressure")
    private String bloodPressure;
    
    @Column(name = "heart_rate")
    private Integer heartRate;
    
    private Double temperature;
    
    @Column(name = "respiratory_rate")
    private Integer respiratoryRate;
    
    @Column(name = "oxygen_saturation")
    private Integer oxygenSaturation;
    
    private Double weight;
    
    private Double height;
    
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
}
