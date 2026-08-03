package com.selva.student_management_system.Dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDepartmentRequest {

    @NotBlank(message = "Department name is required")
    private String departmentName;

    @NotBlank(message = "HOD name is required")
    private String hodName;

}