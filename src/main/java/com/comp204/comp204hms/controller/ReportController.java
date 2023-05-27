package com.comp204.comp204hms.controller;

import com.comp204.comp204hms.dto.patient.PatientDto;
import com.comp204.comp204hms.dto.patient.PatientRequestDto;
import com.comp204.comp204hms.dto.report.ReportDto;
import com.comp204.comp204hms.dto.report.ReportRequestDto;
import com.comp204.comp204hms.service.ReportService;
import com.comp204.comp204hms.util.ApiPaths;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiPaths.ReportCtrl.CTRL)
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public ResponseEntity<ReportDto> create(@RequestBody ReportRequestDto reportRequestDto){
        return new ResponseEntity<>(reportService.create(reportRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReportDto>> getAll(@RequestParam Optional<Long> patientId, @RequestParam Optional<Long> doctorId,
    @RequestParam Optional<String> patientTckn){
        if(patientTckn.isPresent()){
            return new ResponseEntity<>(reportService.getByPatientTckn(patientTckn.get()), HttpStatus.OK);
        }
        if(patientId.isPresent()){
            return new ResponseEntity<>(reportService.getByPatientId(patientId.get()), HttpStatus.OK);
        }
        if (doctorId.isPresent()){
            return new ResponseEntity<>(reportService.getByDoctorId(doctorId.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(reportService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(reportService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ReportRequestDto reportRequestDto){
        reportService.update(id, reportRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reportService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
