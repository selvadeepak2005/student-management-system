package com.selva.student_management_system.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentResponse {

    private Long departmentId;

    private String departmentName;

    private String hodName;

}