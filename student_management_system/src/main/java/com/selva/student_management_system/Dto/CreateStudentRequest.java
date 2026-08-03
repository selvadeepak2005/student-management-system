package com.selva.student_management_system.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {

    @NotBlank(message = "Student name is required")
    private String studentName;

    @NotBlank(message = "Register number is required")
    private String registerNumber;

    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Mobile number is required")
    private String mobileNumber;

    @NotNull(message = "Department is required")
    private Long departmentId;
}