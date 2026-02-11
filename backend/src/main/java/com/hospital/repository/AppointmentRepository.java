package com.hospital.repository;

import com.hospital.model.Appointment;
import com.hospital.model.Appointment.AppointmentStatus;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
    List<Appointment> findByPatient(Patient patient);
    
    List<Appointment> findByDoctor(Doctor doctor);
    
    List<Appointment> findByStatus(AppointmentStatus status);
    
    @Query("SELECT a FROM Appointment a WHERE a.doctor = ?1 AND a.appointmentDate BETWEEN ?2 AND ?3")
    List<Appointment> findByDoctorAndDateRange(Doctor doctor, LocalDateTime start, LocalDateTime end);
    
    @Query("SELECT a FROM Appointment a WHERE a.patient = ?1 AND a.appointmentDate BETWEEN ?2 AND ?3")
    List<Appointment> findByPatientAndDateRange(Patient patient, LocalDateTime start, LocalDateTime end);
    
    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate BETWEEN ?1 AND ?2 AND a.status = ?3")
    List<Appointment> findByDateRangeAndStatus(LocalDateTime start, LocalDateTime end, AppointmentStatus status);
    
    @Query("SELECT a FROM Appointment a WHERE a.reminderSent = false AND a.appointmentDate BETWEEN ?1 AND ?2 AND a.status IN ('AGENDADA', 'CONFIRMADA')")
    List<Appointment> findAppointmentsNeedingReminder(LocalDateTime start, LocalDateTime end);
}
