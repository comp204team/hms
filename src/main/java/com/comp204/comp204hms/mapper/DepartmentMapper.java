package com.comp204.comp204hms.mapper;

import com.comp204.comp204hms.dto.department.DepartmentDto;
import com.comp204.comp204hms.dto.department.DepartmentRequestDto;
import com.comp204.comp204hms.dto.doctor.DoctorDto;
import com.comp204.comp204hms.model.Department;
import com.comp204.comp204hms.model.Doctor;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDto departmentToDepartmentDto(Department department);
    @Named(value = "doctorToDoctorDto")
    @Mapping(target = "departmentName", source = "department.name", ignore = true)
    DoctorDto doctorToDoctorDto(Doctor doctor);
    @IterableMapping(qualifiedByName = "doctorToDoctorDto")
    List<DoctorDto> doctorListToDoctorDtoList(List<Doctor> doctors);
    Department departmentDtoToDepartment(DepartmentDto departmentDto);

    Department departmentRequestDtoToDepartment(DepartmentRequestDto departmentRequestDto);
}
