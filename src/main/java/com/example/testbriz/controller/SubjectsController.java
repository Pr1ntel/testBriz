package com.example.testbriz.controller;


import com.example.testbriz.dto.AuditoryResponseDto;
import com.example.testbriz.dto.SubjectsRequestDto;
import com.example.testbriz.dto.SubjectsResponseDto;
import com.example.testbriz.service.SubjectsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class SubjectsController {
    private final SubjectsService subjectsService;

    @PostMapping(value = "/new-subject")
    public void addNewSubject(@RequestBody SubjectsRequestDto subjectsRequestDto) {
        subjectsService.addNewSubject(subjectsRequestDto);
    }

    @GetMapping(value = "/all-subjects")
    public List<SubjectsResponseDto> getAllSubjects() {
        return subjectsService.getAll();
    }
}
