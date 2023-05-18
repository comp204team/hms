package com.comp204.comp204hms.mapper;

import com.comp204.comp204hms.dto.doctor.DoctorDto;
import com.comp204.comp204hms.dto.doctor.DoctorRequestDto;
import com.comp204.comp204hms.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    DoctorDto toDto(Doctor doctor);

    Doctor toEntity(DoctorRequestDto doctorRequestDto);
}
