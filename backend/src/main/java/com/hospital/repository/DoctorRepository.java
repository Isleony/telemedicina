package com.hospital.repository;

import com.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    Optional<Doctor> findByCrm(String crm);
    
    Optional<Doctor> findByCpf(String cpf);
    
    List<Doctor> findByNameContainingIgnoreCase(String name);
    
    List<Doctor> findByActive(Boolean active);
    
    @Query("SELECT d FROM Doctor d JOIN d.specialties s WHERE s = ?1")
    List<Doctor> findBySpecialty(String specialty);
    
    List<Doctor> findByAcceptsTelemedicine(Boolean acceptsTelemedicine);
}
