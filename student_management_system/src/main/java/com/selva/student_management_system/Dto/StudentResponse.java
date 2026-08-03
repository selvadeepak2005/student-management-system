package com.selva.student_management_system.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {

    private Long studentId;

    private String studentName;

    private String registerNumber;

    private String email;

    private String mobileNumber;

    private String departmentName;
}