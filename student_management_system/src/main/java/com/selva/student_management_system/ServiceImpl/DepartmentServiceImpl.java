package com.selva.student_management_system.ServiceImpl;
import com.selva.student_management_system.Dto.CreateDepartmentRequest;
import com.selva.student_management_system.Dto.DepartmentResponse;
import com.selva.student_management_system.Entity.Department;
import com.selva.student_management_system.Exception.DuplicateResourceException;
import com.selva.student_management_system.Exception.ResourceNotFoundException;
import com.selva.student_management_system.Repository.DepartmentRepository;
import com.selva.student_management_system.Service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDepartment(CreateDepartmentRequest request) {

        if (departmentRepository.existsByDepartmentName(request.getDepartmentName())) {
            throw new DuplicateResourceException("Department already exists");
        }

        Department department = Department.builder()
                .departmentName(request.getDepartmentName())
                .hodName(request.getHodName())
                .build();

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentResponse.builder()
                .departmentId(savedDepartment.getDepartmentId())
                .departmentName(savedDepartment.getDepartmentName())
                .hodName(savedDepartment.getHodName())
                .build();
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(department -> DepartmentResponse.builder()
                        .departmentId(department.getDepartmentId())
                        .departmentName(department.getDepartmentName())
                        .hodName(department.getHodName())
                        .build())
                .toList();
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found with id : " + id));

        return DepartmentResponse.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .hodName(department.getHodName())
                .build();
    }

    @Override
    public DepartmentResponse updateDepartment(Long id,
                                               CreateDepartmentRequest request) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found with id : " + id));

        department.setDepartmentName(request.getDepartmentName());
        department.setHodName(request.getHodName());

        Department updatedDepartment = departmentRepository.save(department);

        return DepartmentResponse.builder()
                .departmentId(updatedDepartment.getDepartmentId())
                .departmentName(updatedDepartment.getDepartmentName())
                .hodName(updatedDepartment.getHodName())
                .build();
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found with id : " + id));

        departmentRepository.delete(department);
    }
}