package com.selva.student_management_system.Service;

import com.selva.student_management_system.Dto.CreateStudentRequest;
import com.selva.student_management_system.Dto.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(CreateStudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(Long id,
                                  CreateStudentRequest request);

    void deleteStudent(Long id);

}