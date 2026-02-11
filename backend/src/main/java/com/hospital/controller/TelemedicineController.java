package com.hospital.controller;

import com.hospital.model.Teleconsultation;
import com.hospital.repository.TeleconsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/telemedicine")
@CrossOrigin(origins = "http://localhost:3000")
public class TelemedicineController {
    
    @Autowired
    private TeleconsultationRepository teleconsultationRepository;
    
    @GetMapping("/consultations")
    public ResponseEntity<List<Teleconsultation>> getAllConsultations() {
        return ResponseEntity.ok(teleconsultationRepository.findAll());
    }
    
    @GetMapping("/consultations/{id}")
    public ResponseEntity<Teleconsultation> getConsultationById(@PathVariable Long id) {
        return teleconsultationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/consultations/meeting/{meetingId}")
    public ResponseEntity<Teleconsultation> getConsultationByMeetingId(@PathVariable String meetingId) {
        return teleconsultationRepository.findByMeetingId(meetingId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/consultations/status/{status}")
    public ResponseEntity<List<Teleconsultation>> getConsultationsByStatus(
            @PathVariable Teleconsultation.TeleconsultationStatus status) {
        return ResponseEntity.ok(teleconsultationRepository.findByStatus(status));
    }
    
    @PostMapping("/consultations")
    public ResponseEntity<Teleconsultation> createConsultation(@RequestBody Teleconsultation teleconsultation) {
        // Generate meeting ID if not provided
        if (teleconsultation.getMeetingId() == null) {
            teleconsultation.setMeetingId(UUID.randomUUID().toString());
        }
        
        Teleconsultation saved = teleconsultationRepository.save(teleconsultation);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @PutMapping("/consultations/{id}")
    public ResponseEntity<Teleconsultation> updateConsultation(
            @PathVariable Long id, 
            @RequestBody Teleconsultation teleconsultation) {
        if (!teleconsultationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        teleconsultation.setId(id);
        return ResponseEntity.ok(teleconsultationRepository.save(teleconsultation));
    }
    
    @PatchMapping("/consultations/{id}/join/patient")
    public ResponseEntity<Teleconsultation> patientJoin(@PathVariable Long id) {
        Teleconsultation consultation = teleconsultationRepository.findById(id).orElse(null);
        if (consultation == null) {
            return ResponseEntity.notFound().build();
        }
        consultation.setPatientJoined(true);
        consultation.setPatientJoinTime(java.time.LocalDateTime.now());
        return ResponseEntity.ok(teleconsultationRepository.save(consultation));
    }
    
    @PatchMapping("/consultations/{id}/join/doctor")
    public ResponseEntity<Teleconsultation> doctorJoin(@PathVariable Long id) {
        Teleconsultation consultation = teleconsultationRepository.findById(id).orElse(null);
        if (consultation == null) {
            return ResponseEntity.notFound().build();
        }
        consultation.setDoctorJoined(true);
        consultation.setDoctorJoinTime(java.time.LocalDateTime.now());
        consultation.setStatus(Teleconsultation.TeleconsultationStatus.EM_ANDAMENTO);
        return ResponseEntity.ok(teleconsultationRepository.save(consultation));
    }
    
    @DeleteMapping("/consultations/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable Long id) {
        if (!teleconsultationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        teleconsultationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
