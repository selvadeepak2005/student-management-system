package com.selva.student_management_system.ServiceImpl;
import com.selva.student_management_system.Dto.CreateStudentRequest;
import com.selva.student_management_system.Dto.StudentResponse;
import com.selva.student_management_system.Entity.Department;
import com.selva.student_management_system.Entity.Student;
import com.selva.student_management_system.Exception.DuplicateResourceException;
import com.selva.student_management_system.Exception.ResourceNotFoundException;
import com.selva.student_management_system.Repository.DepartmentRepository;
import com.selva.student_management_system.Repository.StudentRepository;
import com.selva.student_management_system.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public StudentResponse createStudent(CreateStudentRequest request) {

        if (studentRepository.existsByRegisterNumber(request.getRegisterNumber())) {
            throw new DuplicateResourceException("Register number already exists");
        }

        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found with id : " + request.getDepartmentId()));

        Student student = Student.builder()
                .studentName(request.getStudentName())
                .registerNumber(request.getRegisterNumber())
                .email(request.getEmail())
                .mobileNumber(request.getMobileNumber())
                .department(department)
                .build();

        Student savedStudent = studentRepository.save(student);

        return StudentResponse.builder()
                .studentId(savedStudent.getStudentId())
                .studentName(savedStudent.getStudentName())
                .registerNumber(savedStudent.getRegisterNumber())
                .email(savedStudent.getEmail())
                .mobileNumber(savedStudent.getMobileNumber())
                .departmentName(savedStudent.getDepartment().getDepartmentName())
                .build();
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(student -> StudentResponse.builder()
                        .studentId(student.getStudentId())
                        .studentName(student.getStudentName())
                        .registerNumber(student.getRegisterNumber())
                        .email(student.getEmail())
                        .mobileNumber(student.getMobileNumber())
                        .departmentName(student.getDepartment().getDepartmentName())
                        .build())
                .toList();
    }

    @Override
    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id : " + id));

        return StudentResponse.builder()
                .studentId(student.getStudentId())
                .studentName(student.getStudentName())
                .registerNumber(student.getRegisterNumber())
                .email(student.getEmail())
                .mobileNumber(student.getMobileNumber())
                .departmentName(student.getDepartment().getDepartmentName())
                .build();
    }

    @Override
    public StudentResponse updateStudent(Long id,
                                         CreateStudentRequest request) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id : " + id));

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found with id : " + request.getDepartmentId()));

        student.setStudentName(request.getStudentName());
        student.setRegisterNumber(request.getRegisterNumber());
        student.setEmail(request.getEmail());
        student.setMobileNumber(request.getMobileNumber());
        student.setDepartment(department);

        Student updatedStudent = studentRepository.save(student);

        return StudentResponse.builder()
                .studentId(updatedStudent.getStudentId())
                .studentName(updatedStudent.getStudentName())
                .registerNumber(updatedStudent.getRegisterNumber())
                .email(updatedStudent.getEmail())
                .mobileNumber(updatedStudent.getMobileNumber())
                .departmentName(updatedStudent.getDepartment().getDepartmentName())
                .build();
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id : " + id));

        studentRepository.delete(student);
    }
}