package com.selva.student_management_system.Service;

import com.selva.student_management_system.Dto.CreateDepartmentRequest;
import com.selva.student_management_system.Dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse createDepartment(CreateDepartmentRequest request);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartmentById(Long id);

    DepartmentResponse updateDepartment(Long id, CreateDepartmentRequest request);

    void deleteDepartment(Long id);

}