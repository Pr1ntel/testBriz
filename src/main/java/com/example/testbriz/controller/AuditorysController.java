package com.example.testbriz.controller;


import com.example.testbriz.dto.AuditoryRequestDto;
import com.example.testbriz.dto.AuditoryResponseDto;
import com.example.testbriz.dto.StudentsRequestDto;
import com.example.testbriz.dto.StudentsResponseDto;
import com.example.testbriz.service.AuditorysService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class AuditorysController {
    private final AuditorysService auditorysService;

    @GetMapping(value = "/all-auditorys")
    public List<AuditoryResponseDto> getAllStudents() {
        return auditorysService.getAll();
    }
    @DeleteMapping(value = "delete-auditorys/{id}")
    public void deleteAuditorys(@PathVariable int id) {
        auditorysService.deleteById(id);
    }
    @PostMapping(value = "/new-auditorys")
    public void addNewAuditorys(@RequestBody AuditoryRequestDto auditoryRequestDto) {
        auditorysService.addNewAuditorys(auditoryRequestDto);
    }
}
