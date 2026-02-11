package com.hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String cpf;
    
    @Column(unique = true)
    private String rg;
    
    @Column(name = "birth_date")
    private LocalDate birthDate;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Column(name = "blood_type")
    private String bloodType;
    
    private String email;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "emergency_contact")
    private String emergencyContact;
    
    @Column(name = "emergency_phone")
    private String emergencyPhone;
    
    @Embedded
    private Address address;
    
    @Column(name = "health_insurance")
    private String healthInsurance;
    
    @Column(name = "insurance_number")
    private String insuranceNumber;
    
    @Column(columnDefinition = "TEXT")
    private String allergies;
    
    @Column(name = "chronic_conditions", columnDefinition = "TEXT")
    private String chronicConditions;
    
    @Column(name = "current_medications", columnDefinition = "TEXT")
    private String currentMedications;
    
    private Boolean active = true;
    
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
    
    public enum Gender {
        MASCULINO, FEMININO, OUTRO
    }
}
