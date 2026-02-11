package com.hospital.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "beds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bed {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "bed_number", nullable = false, unique = true)
    private String bedNumber;
    
    @Column(name = "room_number")
    private String roomNumber;
    
    @Column(name = "floor")
    private String floor;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedType type;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedStatus status = BedStatus.DISPONIVEL;
    
    @Column(name = "department")
    private String department;
    
    private Boolean active = true;
    
    @Column(name = "last_cleaned")
    private LocalDateTime lastCleaned;
    
    @Column(columnDefinition = "TEXT")
    private String observations;
    
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
    
    public enum BedType {
        ENFERMARIA, APARTAMENTO, UTI, SEMI_UTI, ISOLAMENTO, ONCOLOGIA
    }
    
    public enum BedStatus {
        DISPONIVEL, OCUPADO, MANUTENCAO, LIMPEZA, RESERVADO
    }
}
