package com.comp204.comp204hms.controller;


import com.comp204.comp204hms.dto.department.DepartmentDto;
import com.comp204.comp204hms.dto.department.DepartmentRequestDto;
import com.comp204.comp204hms.service.DepartmentService;
import com.comp204.comp204hms.util.ApiPaths;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.DepartmentCtrl.CTRL)
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentRequestDto departmentRequestDto){
        return new ResponseEntity<>(departmentService.create(departmentRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAll(){
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DepartmentDto> update(@PathVariable Long id, @RequestBody DepartmentRequestDto departmentRequestDto){
        departmentService.update(id, departmentRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentDto> delete(@PathVariable Long id){
        departmentService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
