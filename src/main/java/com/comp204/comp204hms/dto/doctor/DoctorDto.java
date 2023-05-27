package com.comp204.comp204hms.dto.doctor;

import com.comp204.comp204hms.dto.department.DepartmentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorDto {

    private Long id;

    private String tckn;

    private String name;

    private String surname;

    private DepartmentDto department;

}
