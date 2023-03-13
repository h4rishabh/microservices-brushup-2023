package com.hb.departmentservice.service;

import com.hb.departmentservice.dto.DepartmentDTO;
import com.hb.departmentservice.entity.Department;
import com.hb.departmentservice.exception.ResourceNotFoundException;
import com.hb.departmentservice.mapper.DepartmentMapper;
import com.hb.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        // department DepartmentDTO to Department JPA Entity
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDTO savedDepartmentDTO = DepartmentMapper.mapToDepartmentDTO(savedDepartment);
        return savedDepartmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Optional<Department> department = departmentRepository.findByDepartmentCode(departmentCode);
        if(!department.isPresent()) {
            throw new ResourceNotFoundException("Department", "departmentCode", departmentCode);
        }

        DepartmentDTO fetchedDepartment = DepartmentMapper.mapToDepartmentDTO(department.get());
        return fetchedDepartment;
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> departmentlist = departmentRepository.findAll();
        List<DepartmentDTO> departmentDtoList = new ArrayList<>();

        departmentlist.forEach(
                (dept) -> departmentDtoList.add(DepartmentMapper.mapToDepartmentDTO(dept))
        );
        return departmentDtoList;

    }
}
