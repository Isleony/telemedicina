package com.hospital.repository;

import com.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    Optional<Patient> findByCpf(String cpf);
    
    List<Patient> findByNameContainingIgnoreCase(String name);
    
    List<Patient> findByActive(Boolean active);
    
    @Query("SELECT p FROM Patient p WHERE p.healthInsurance = ?1")
    List<Patient> findByHealthInsurance(String healthInsurance);
}
