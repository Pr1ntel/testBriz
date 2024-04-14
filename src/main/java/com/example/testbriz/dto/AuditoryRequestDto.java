package com.example.testbriz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditoryRequestDto {
    private int yearOfStudy;
    private String auditoryName;
    private int teachers;
    private int subjects;
    private int students;

}
