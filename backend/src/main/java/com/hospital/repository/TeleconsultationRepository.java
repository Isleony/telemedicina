package com.hospital.repository;

import com.hospital.model.Teleconsultation;
import com.hospital.model.Teleconsultation.TeleconsultationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeleconsultationRepository extends JpaRepository<Teleconsultation, Long> {
    
    Optional<Teleconsultation> findByMeetingId(String meetingId);
    
    List<Teleconsultation> findByStatus(TeleconsultationStatus status);
}
