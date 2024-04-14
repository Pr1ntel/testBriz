package com.example.testbriz.controller;

import com.example.testbriz.dto.StudentsResponseDto;
import com.example.testbriz.dto.SubjectsRequestDto;
import com.example.testbriz.dto.TeachersRequestDto;
import com.example.testbriz.dto.TeachersResponseDto;
import com.example.testbriz.service.TeachersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class TeachersController {
    private final TeachersService teachersService;

    @GetMapping(value = "/all-teachers")
    public List<TeachersResponseDto> getAllStudents() {
        return teachersService.getAll();
    }
    @DeleteMapping(value = "delete-teacher/{id}")
    public void deleteTeacher(@PathVariable int id) {
        teachersService.deleteById(id);
    }
    @PostMapping(value = "/new-teachers")
    public void addNewSubject(@RequestBody TeachersRequestDto teachersRequestDto) {
        teachersService.addNewTeachers(teachersRequestDto);
    }
}
