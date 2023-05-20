package com.comp204.comp204hms.repository;

import com.comp204.comp204hms.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByDoctor_Id(Long doctorId);
    List<Report> findAllByPatient_Id(Long patientId);
}
