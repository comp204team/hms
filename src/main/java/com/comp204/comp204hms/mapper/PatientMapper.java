package com.comp204.comp204hms.mapper;

import com.comp204.comp204hms.dto.patient.PatientDto;
import com.comp204.comp204hms.dto.patient.PatientRequestDto;
import com.comp204.comp204hms.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDto toDto(Patient patient);

    @Mapping(target = "room", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    Patient toEntity(PatientRequestDto patientRequestDto);
}
