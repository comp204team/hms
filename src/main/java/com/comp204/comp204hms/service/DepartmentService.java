package com.comp204.comp204hms.service;

import com.comp204.comp204hms.dto.department.DepartmentDto;
import com.comp204.comp204hms.dto.department.DepartmentRequestDto;
import com.comp204.comp204hms.exception.NotFoundException;
import com.comp204.comp204hms.mapper.DepartmentMapper;
import com.comp204.comp204hms.model.Department;
import com.comp204.comp204hms.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;



    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public DepartmentDto create(DepartmentRequestDto departmentRequestDto){
        Department department = DepartmentMapper.INSTANCE.departmentRequestDtoToDepartment(departmentRequestDto);
        department = departmentRepository.save(department);
        return DepartmentMapper.INSTANCE.departmentToDepartmentDto(department);
    }

    public List<DepartmentDto> getAll(){
        return departmentRepository.findAll().stream().map(DepartmentMapper.INSTANCE::departmentToDepartmentDto).collect(Collectors.toList());
    }

    public void update(Long id, DepartmentRequestDto departmentRequestDto){
        Department department = getDepartmentByIdOrThrowNotFoundError(id);

        if(departmentRequestDto.getName() != null){
            department.setName(departmentRequestDto.getName());
        }
        if(departmentRequestDto.getDescription() != null){
            department.setDescription(departmentRequestDto.getDescription());
        }

        departmentRepository.save(department);
    }

    public void delete(Long id){
        Department department = getDepartmentByIdOrThrowNotFoundError(id);

        departmentRepository.delete(department);
    }


    private Department getDepartmentByIdOrThrowNotFoundError(Long id){
        return departmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Department",
                "No department found with this id"));
    }
}
