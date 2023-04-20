package com.comp204.comp204hms.mapper;

import com.comp204.comp204hms.dto.department.DepartmentDto;
import com.comp204.comp204hms.dto.department.DepartmentRequestDto;
import com.comp204.comp204hms.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    Department departmentDtoToDepartment(DepartmentDto departmentDto);

    DepartmentDto departmentToDepartmentDto(Department department);

    Department departmentRequestDtoToDepartment(DepartmentRequestDto departmentRequestDto);
}
