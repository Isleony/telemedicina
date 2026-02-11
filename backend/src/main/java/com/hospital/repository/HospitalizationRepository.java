package com.hospital.repository;

import com.hospital.model.Hospitalization;
import com.hospital.model.Hospitalization.HospitalizationStatus;
import com.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {
    
    List<Hospitalization> findByPatient(Patient patient);
    
    List<Hospitalization> findByStatus(HospitalizationStatus status);
    
    List<Hospitalization> findByPatientAndStatus(Patient patient, HospitalizationStatus status);
}
