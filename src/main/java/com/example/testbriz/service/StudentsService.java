package com.example.testbriz.service;

import com.example.testbriz.dto.StudentsRequestDto;
import com.example.testbriz.dto.StudentsResponseDto;
import com.example.testbriz.model.Genders;
import com.example.testbriz.model.Students;
import com.example.testbriz.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class StudentsService {
    private final StudentsRepository studentsRepository;
    private final GendersRepository gendersRepository;
    private final SubjectsRepository subjectsRepository;
    private final TeachersRepository teachersRepository;
    private final AuditorysRepository auditorysRepository;

    public List<StudentsResponseDto> getAll() {
        return studentsRepository.findAll().stream().map(
                students -> StudentsResponseDto.builder()
                        .firstName(students.getFirstName())
                        .lastName(students.getLastName())
                        .patronymicName(students.getPatronymicName())
                        .year(students.getYear())
                        .gender(students.getGenders().getGenderName())
                        .build()
        ).collect(Collectors.toList());
    }

    public Students deleteById(int id) {
        return studentsRepository.deleteById(id);
    }

    public void addNewStudents(StudentsRequestDto studentsRequestDto){
        Genders findGenderId = gendersRepository.findById(studentsRequestDto.getGenderId()).get();

        Students insertNewStudent = Students.builder()
                .firstName(studentsRequestDto.getFirstName())
                .lastName(studentsRequestDto.getLastName())
                .patronymicName(studentsRequestDto.getPatronymicName())
                .year(studentsRequestDto.getYear())
                .genders(findGenderId)
                .build();
        studentsRepository.save(insertNewStudent);
    }

}
