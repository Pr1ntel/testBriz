package com.example.testbriz.controller;


import com.example.testbriz.dto.StudentsRequestDto;
import com.example.testbriz.dto.StudentsResponseDto;
import com.example.testbriz.service.StudentsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class StudentsController {
    private final StudentsService studentsService;

    @GetMapping(value = "/all-students")
    public List<StudentsResponseDto> getAllStudents() {
        return studentsService.getAll();
    }

    @DeleteMapping(value = "delete-students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentsService.deleteById(id);
    }
    @PostMapping(value = "/new-students")
    public void addNewTask(@RequestBody StudentsRequestDto studentsRequestDto) {
        studentsService.addNewStudents(studentsRequestDto);
    }

}
