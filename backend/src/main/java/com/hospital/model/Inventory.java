package com.hospital.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemType type;
    
    @Column(nullable = false)
    private String code;
    
    @Column(name = "batch_number")
    private String batchNumber;
    
    @Column(name = "quantity", nullable = false)
    private Integer quantity = 0;
    
    @Column(name = "minimum_quantity")
    private Integer minimumQuantity;
    
    @Column(name = "unit_price")
    private Double unitPrice;
    
    private String manufacturer;
    
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    
    private String location;
    
    @Column(name = "requires_prescription")
    private Boolean requiresPrescription = false;
    
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
    
    public enum ItemType {
        MEDICAMENTO, MATERIAL_CIRURGICO, EQUIPAMENTO, DESCARTAVEL, OUTROS
    }
}
