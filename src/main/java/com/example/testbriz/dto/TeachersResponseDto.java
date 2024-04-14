package com.example.testbriz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeachersResponseDto {
    private String firstName;
    private String lastName;
    private String patronymicName;
    private int year;
    private String gender;
    private String subject;
}
