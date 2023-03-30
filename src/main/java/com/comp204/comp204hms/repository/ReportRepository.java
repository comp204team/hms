package com.comp204.comp204hms.repository;

import com.comp204.comp204hms.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
