package com.hospital.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    
    private String street;
    
    private String number;
    
    private String complement;
    
    private String neighborhood;
    
    private String city;
    
    private String state;
    
    private String zipCode;
    
    private String country;
}
