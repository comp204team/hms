package com.comp204.comp204hms.service;

import com.comp204.comp204hms.dto.department.DepartmentDto;
import com.comp204.comp204hms.dto.doctor.DoctorDto;
import com.comp204.comp204hms.dto.doctor.DoctorRequestDto;
import com.comp204.comp204hms.exception.NotFoundException;
import com.comp204.comp204hms.mapper.DepartmentMapper;
import com.comp204.comp204hms.mapper.DoctorMapper;
import com.comp204.comp204hms.model.Department;
import com.comp204.comp204hms.model.Doctor;
import com.comp204.comp204hms.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    private final DepartmentService departmentService;

    public DoctorService(DoctorRepository doctorRepository, DepartmentService departmentService) {
        this.doctorRepository = doctorRepository;
        this.departmentService = departmentService;
    }

    public DoctorDto create(DoctorRequestDto doctorRequestDto){
        Doctor doctor = DoctorMapper.INSTANCE.toEntity(doctorRequestDto);
        if(doctorRequestDto.getDepartmentId() != null){
            Department department = departmentService.getDepartmentByIdOrReturnNull(doctorRequestDto.getDepartmentId());
            doctor.setDepartment(department);
        }

        return DoctorMapper.INSTANCE.toDto(doctorRepository.save(doctor));
    }

    public List<DoctorDto> getAll(){
        return doctorRepository.findAll().stream().map(DoctorMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public DoctorDto getById(Long id){
        Doctor doctor = getDoctorByIdOrThrowNotFoundError(id);
        return DoctorMapper.INSTANCE.toDto(doctor);
    }

    public DoctorDto update(Long id, DoctorRequestDto doctorRequestDto){
        Doctor doctor = getDoctorByIdOrThrowNotFoundError(id);

        if(doctorRequestDto.getName() != null){
            doctor.setName(doctorRequestDto.getName());
        }
        if(doctorRequestDto.getSurname() != null){
            doctor.setSurname(doctorRequestDto.getSurname());
        }

        return DoctorMapper.INSTANCE.toDto(doctorRepository.save(doctor));
    }

    public void delete(Long id) {
        Doctor doctor = getDoctorByIdOrThrowNotFoundError(id);
        doctorRepository.delete(doctor);
    }

    protected Doctor getDoctorByIdOrThrowNotFoundError(Long id){
        return doctorRepository.findById(id).orElseThrow(() -> new NotFoundException("Doctor"));
    }

}
