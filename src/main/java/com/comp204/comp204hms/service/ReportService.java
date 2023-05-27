package com.comp204.comp204hms.service;

import com.comp204.comp204hms.dto.report.ReportDto;
import com.comp204.comp204hms.dto.report.ReportRequestDto;
import com.comp204.comp204hms.exception.NotFoundException;
import com.comp204.comp204hms.mapper.ReportMapper;
import com.comp204.comp204hms.model.Report;
import com.comp204.comp204hms.repository.DoctorRepository;
import com.comp204.comp204hms.repository.PatientRepository;
import com.comp204.comp204hms.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;

    public ReportService(ReportRepository reportRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.reportRepository = reportRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public ReportDto create(ReportRequestDto reportRequestDto){
        Report report = ReportMapper.INSTANCE.toEntity(reportRequestDto);
        if(reportRequestDto.getDoctorId() != null){
            report.setDoctor(doctorRepository.findById(reportRequestDto.getDoctorId()).orElse(null));
        }
        if(reportRequestDto.getPatientId() != null){
            report.setPatient(patientRepository.findById(reportRequestDto.getPatientId()).orElse(null));
        }

        return ReportMapper.INSTANCE.toDto(reportRepository.save(report));
    }

    public List<ReportDto> getAll(){
        return reportRepository.findAll().stream().map(ReportMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public List<ReportDto> getByPatientId(Long patientId){
        return reportRepository.findAllByPatient_Id(patientId).stream().map(ReportMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public List<ReportDto> getByDoctorId(Long doctorId){
        return reportRepository.findAllByDoctor_Id(doctorId).stream().map(ReportMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public List<ReportDto> getByPatientTckn(String tckn){
        return reportRepository.findAllByPatient_Tckn(tckn).stream().map(ReportMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public ReportDto getById(Long id){
        return ReportMapper.INSTANCE.toDto(getByIdOrThrowNotFoundError(id));
    }

    public ReportDto update(Long id, ReportRequestDto reportRequestDto){
        Report report = getByIdOrThrowNotFoundError(id);

        if(reportRequestDto.getDisease() != null){
            report.setDisease(reportRequestDto.getDisease());
        }
        if(reportRequestDto.getDescription() != null){
            report.setDescription(reportRequestDto.getDescription());
        }
        if(reportRequestDto.getPhotoUrl() != null){
            report.setPhotoUrl(reportRequestDto.getPhotoUrl());
        }
        if(reportRequestDto.getDoctorId() != null){
            report.setDoctor(doctorRepository.findById(reportRequestDto.getDoctorId()).orElse(null));
        }
        if(reportRequestDto.getPatientId() != null){
            report.setPatient(patientRepository.findById(reportRequestDto.getPatientId()).orElse(null));
        }

        return ReportMapper.INSTANCE.toDto(reportRepository.save(report));
    }

    public void deleteById(Long id){
        Report report = getByIdOrThrowNotFoundError(id);
        reportRepository.delete(report);
    }

    protected Report getByIdOrThrowNotFoundError(Long id){
        return reportRepository.findById(id).orElseThrow(() -> new NotFoundException("Report"));
    }
}
