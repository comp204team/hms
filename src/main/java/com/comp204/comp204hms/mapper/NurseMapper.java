package com.comp204.comp204hms.mapper;

import com.comp204.comp204hms.dto.nurse.NurseDto;
import com.comp204.comp204hms.dto.nurse.NurseRequestDto;
import com.comp204.comp204hms.model.Nurse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NurseMapper {

    NurseMapper INSTANCE = Mappers.getMapper(NurseMapper.class);

    NurseDto toDto(Nurse nurse);

    @Mapping(target = "rooms", ignore = true)
    Nurse toEntity(NurseRequestDto nurseRequestDto);
}
