package com.comp204.comp204hms.controller;


import com.comp204.comp204hms.dto.patient.PatientDto;
import com.comp204.comp204hms.dto.patient.PatientRequestDto;
import com.comp204.comp204hms.service.PatientService;
import com.comp204.comp204hms.util.ApiPaths;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.PatientCtrl.CTRL)
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientDto> create(@RequestBody PatientRequestDto patientRequestDto){
        return new ResponseEntity<>(patientService.create(patientRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAll(){
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(patientService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PatientRequestDto patientRequestDto){
        patientService.update(id, patientRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        patientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
