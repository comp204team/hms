package com.comp204.comp204hms.controller;

import com.comp204.comp204hms.dto.doctor.DoctorDto;
import com.comp204.comp204hms.dto.doctor.DoctorRequestDto;
import com.comp204.comp204hms.service.DoctorService;
import com.comp204.comp204hms.util.ApiPaths;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.DoctorCtrl.CTRL)
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDto> create(@RequestBody DoctorRequestDto doctorRequestDto){
        return new ResponseEntity<>(doctorService.create(doctorRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAll(){
        return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(doctorService.getById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DoctorDto> update(@PathVariable Long id, @RequestBody DoctorRequestDto doctorRequestDto){
        return new ResponseEntity<>(doctorService.update(id, doctorRequestDto), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
