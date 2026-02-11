package com.hospital.repository;

import com.hospital.model.OncologyTreatment;
import com.hospital.model.OncologyTreatment.TreatmentStatus;
import com.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OncologyTreatmentRepository extends JpaRepository<OncologyTreatment, Long> {
    
    List<OncologyTreatment> findByPatient(Patient patient);
    
    List<OncologyTreatment> findByStatus(TreatmentStatus status);
    
    List<OncologyTreatment> findByPatientAndStatus(Patient patient, TreatmentStatus status);
}
