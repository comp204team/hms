package com.comp204.comp204hms.repository;

import com.comp204.comp204hms.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
