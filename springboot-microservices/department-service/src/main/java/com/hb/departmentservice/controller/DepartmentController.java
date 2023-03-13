package com.hb.departmentservice.controller;

import com.hb.departmentservice.dto.DepartmentDTO;
import com.hb.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build REST API to create Department
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartmentDTO  = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.CREATED);
    }

    // Build REST API to get Department by Code
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> findDepartmentByCode(@PathVariable("department-code") String departmentCode){
        DepartmentDTO fetchedDepartmentDTO  = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(fetchedDepartmentDTO, HttpStatus.OK);
    }

    // Build REST API to get Department by Code
    @GetMapping()
    public ResponseEntity<List<DepartmentDTO>> findAllDepartment(){
        List<DepartmentDTO> deptDtoList  = departmentService.getAllDepartment();
        return new ResponseEntity<>(deptDtoList, HttpStatus.OK);
    }
}
