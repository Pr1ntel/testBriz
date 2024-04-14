package com.example.testbriz.service;

import com.example.testbriz.dto.AuditoryRequestDto;
import com.example.testbriz.dto.AuditoryResponseDto;
import com.example.testbriz.model.*;
import com.example.testbriz.repository.AuditorysRepository;
import com.example.testbriz.repository.StudentsRepository;
import com.example.testbriz.repository.SubjectsRepository;
import com.example.testbriz.repository.TeachersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AuditorysService {
    private final AuditorysRepository auditorysRepository;
    private final TeachersRepository teachersRepository;
    private final SubjectsRepository subjectsRepository;
    private final StudentsRepository studentsRepository;

    public List<AuditoryResponseDto> getAll() {
        return auditorysRepository.findAll().stream().map(
                auditorys -> AuditoryResponseDto.builder()
                        .yearOfStudy(auditorys.getYearOfStudy())
                        .auditoryName(auditorys.getAuditoryName())
                        .teachers(auditorys.getTeachers().getFirstName() + " " + auditorys.getTeachers().getLastName())
                        .subjects(auditorys.getSubjects().getSubjectName())
                        .students(auditorys.getStudents().getFirstName() + " " + auditorys.getStudents().getLastName())
                        .build()
        ).collect(Collectors.toList());
    }
    public Auditorys deleteById(int id) {
        return auditorysRepository.deleteById(id);
    }

    public void addNewAuditorys(AuditoryRequestDto auditoryRequestDto){
        Teachers findTeachersId = teachersRepository.findById(auditoryRequestDto.getTeachers()).get();
        Subjects findSubjectsId = subjectsRepository.findById(auditoryRequestDto.getSubjects()).get();
        Students findStudentsId = studentsRepository.findById(auditoryRequestDto.getStudents()).get();

        Auditorys insertAuditory = Auditorys.builder()
                .yearOfStudy(auditoryRequestDto.getYearOfStudy())
                .auditoryName(auditoryRequestDto.getAuditoryName())
                .teachers(findTeachersId)
                .subjects(findSubjectsId)
                .students(findStudentsId)
                .build();
        auditorysRepository.save(insertAuditory);

    }
}
