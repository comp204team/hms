package com.comp204.comp204hms.dto.doctor;

import com.comp204.comp204hms.dto.department.DepartmentDto;
import com.comp204.comp204hms.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    private Long tckn;
    private String name;
    private String surname;
    private String departmentName;
}
