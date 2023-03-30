package com.comp204.comp204hms.repository;

import com.comp204.comp204hms.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
}
