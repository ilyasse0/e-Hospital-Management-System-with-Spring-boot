package com.hospital.apphospital.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.apphospital.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient , Long> {
    Page<Patient> findByNomContains(String keyword , Pageable pageable);
    
}
