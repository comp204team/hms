package com.comp204.comp204hms.mapper;

import com.comp204.comp204hms.dto.report.ReportDto;
import com.comp204.comp204hms.dto.report.ReportRequestDto;
import com.comp204.comp204hms.model.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "patient", ignore = true)
    Report toEntity(ReportRequestDto reportRequestDto);

    ReportDto toDto(Report report);
}
