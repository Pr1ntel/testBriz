package com.example.testbriz.service;

import com.example.testbriz.dto.StudentsResponseDto;
import com.example.testbriz.dto.SubjectsRequestDto;
import com.example.testbriz.dto.TeachersRequestDto;
import com.example.testbriz.dto.TeachersResponseDto;
import com.example.testbriz.model.Genders;
import com.example.testbriz.model.Students;
import com.example.testbriz.model.Subjects;
import com.example.testbriz.model.Teachers;
import com.example.testbriz.repository.GendersRepository;
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
public class TeachersService {
    private final TeachersRepository teachersRepository;
    private final GendersRepository gendersRepository;
    private final SubjectsRepository subjectsRepository;

    public List<TeachersResponseDto> getAll() {
        return teachersRepository.findAll().stream().map(
                teachers -> TeachersResponseDto.builder()
                        .firstName(teachers.getFirstName())
                        .lastName(teachers.getLastName())
                        .patronymicName(teachers.getPatronymicName())
                        .year(teachers.getYear())
                        .gender(teachers.getGenders().getGenderName())
                        .subject(teachers.getSubjects().getSubjectName())
                        .build()
        ).collect(Collectors.toList());
    }

    public Teachers deleteById(int id) {
        return teachersRepository.deleteById(id);
    }
    public void addNewTeachers(TeachersRequestDto teachersRequestDto){
        Genders findGendersById = gendersRepository.findById(teachersRequestDto.getGender()).get();
        Subjects findSubjectsId = subjectsRepository.findById(teachersRequestDto.getSubject()).get();

        Teachers insertNewTeachers = Teachers.builder()
                .firstName(teachersRequestDto.getFirstName())
                .lastName(teachersRequestDto.getLastName())
                .patronymicName(teachersRequestDto.getPatronymicName())
                .year(teachersRequestDto.getYear())
                .genders(findGendersById)
                .subjects(findSubjectsId)
                .build();
        teachersRepository.save(insertNewTeachers);
    }
}
