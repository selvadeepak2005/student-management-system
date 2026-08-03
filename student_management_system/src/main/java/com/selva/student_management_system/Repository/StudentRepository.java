package com.selva.student_management_system.Repository;


import com.selva.student_management_system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByRegisterNumber(String registerNumber);

    boolean existsByEmail(String email);

}