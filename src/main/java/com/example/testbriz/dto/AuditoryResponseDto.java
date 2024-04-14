package com.example.testbriz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditoryResponseDto {
    private int yearOfStudy;
    private String auditoryName;
    private String teachers;
    private String subjects;
    private String students;
}
