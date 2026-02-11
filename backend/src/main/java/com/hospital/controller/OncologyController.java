package com.hospital.controller;

import com.hospital.model.OncologyTreatment;
import com.hospital.model.Patient;
import com.hospital.repository.OncologyTreatmentRepository;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oncology")
@CrossOrigin(origins = "http://localhost:3000")
public class OncologyController {
    
    @Autowired
    private OncologyTreatmentRepository treatmentRepository;
    
    @Autowired
    private PatientRepository patientRepository;
    
    @GetMapping("/treatments")
    public ResponseEntity<List<OncologyTreatment>> getAllTreatments() {
        return ResponseEntity.ok(treatmentRepository.findAll());
    }
    
    @GetMapping("/treatments/{id}")
    public ResponseEntity<OncologyTreatment> getTreatmentById(@PathVariable Long id) {
        return treatmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/treatments/patient/{patientId}")
    public ResponseEntity<List<OncologyTreatment>> getTreatmentsByPatient(@PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(treatmentRepository.findByPatient(patient));
    }
    
    @GetMapping("/treatments/status/{status}")
    public ResponseEntity<List<OncologyTreatment>> getTreatmentsByStatus(
            @PathVariable OncologyTreatment.TreatmentStatus status) {
        return ResponseEntity.ok(treatmentRepository.findByStatus(status));
    }
    
    @PostMapping("/treatments")
    public ResponseEntity<OncologyTreatment> createTreatment(@RequestBody OncologyTreatment treatment) {
        OncologyTreatment savedTreatment = treatmentRepository.save(treatment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTreatment);
    }
    
    @PutMapping("/treatments/{id}")
    public ResponseEntity<OncologyTreatment> updateTreatment(
            @PathVariable Long id, 
            @RequestBody OncologyTreatment treatment) {
        if (!treatmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        treatment.setId(id);
        return ResponseEntity.ok(treatmentRepository.save(treatment));
    }
    
    @PatchMapping("/treatments/{id}/session")
    public ResponseEntity<OncologyTreatment> recordSession(@PathVariable Long id) {
        OncologyTreatment treatment = treatmentRepository.findById(id).orElse(null);
        if (treatment == null) {
            return ResponseEntity.notFound().build();
        }
        treatment.setCompletedSessions(treatment.getCompletedSessions() + 1);
        return ResponseEntity.ok(treatmentRepository.save(treatment));
    }
    
    @DeleteMapping("/treatments/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable Long id) {
        if (!treatmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        treatmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
