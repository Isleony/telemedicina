package com.hospital.repository;

import com.hospital.model.Bed;
import com.hospital.model.Bed.BedStatus;
import com.hospital.model.Bed.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {
    
    Optional<Bed> findByBedNumber(String bedNumber);
    
    List<Bed> findByStatus(BedStatus status);
    
    List<Bed> findByType(BedType type);
    
    List<Bed> findByTypeAndStatus(BedType type, BedStatus status);
    
    List<Bed> findByDepartment(String department);
    
    List<Bed> findByFloor(String floor);
}
