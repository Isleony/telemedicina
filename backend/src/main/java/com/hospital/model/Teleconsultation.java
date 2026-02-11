package com.hospital.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "teleconsultations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teleconsultation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointment appointment;
    
    @Column(name = "meeting_link", nullable = false)
    private String meetingLink;
    
    @Column(name = "meeting_id", unique = true)
    private String meetingId;
    
    @Column(name = "meeting_password")
    private String meetingPassword;
    
    @Column(name = "start_time")
    private LocalDateTime startTime;
    
    @Column(name = "end_time")
    private LocalDateTime endTime;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TeleconsultationStatus status = TeleconsultationStatus.AGENDADA;
    
    @Column(name = "patient_joined")
    private Boolean patientJoined = false;
    
    @Column(name = "doctor_joined")
    private Boolean doctorJoined = false;
    
    @Column(name = "patient_join_time")
    private LocalDateTime patientJoinTime;
    
    @Column(name = "doctor_join_time")
    private LocalDateTime doctorJoinTime;
    
    @Column(name = "duration_minutes")
    private Integer durationMinutes;
    
    @Column(name = "recording_url")
    private String recordingUrl;
    
    @Column(name = "chat_transcript", columnDefinition = "TEXT")
    private String chatTranscript;
    
    @Column(name = "technical_issues", columnDefinition = "TEXT")
    private String technicalIssues;
    
    @Column(name = "quality_rating")
    private Integer qualityRating;
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
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
    
    public enum TeleconsultationStatus {
        AGENDADA, EM_ANDAMENTO, CONCLUIDA, CANCELADA, FALHA_TECNICA
    }
}
