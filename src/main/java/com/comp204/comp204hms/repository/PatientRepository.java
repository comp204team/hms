package com.comp204.comp204hms.repository;

import com.comp204.comp204hms.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
