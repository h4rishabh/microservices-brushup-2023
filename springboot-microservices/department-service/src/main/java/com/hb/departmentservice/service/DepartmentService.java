package com.hb.departmentservice.service;

import com.hb.departmentservice.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentByCode(String code);

    List<DepartmentDTO> getAllDepartment();
}
