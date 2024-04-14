package com.example.testbriz.service;

import com.example.testbriz.dto.GendersResponseDto;
import com.example.testbriz.dto.SubjectsRequestDto;
import com.example.testbriz.dto.SubjectsResponseDto;
import com.example.testbriz.model.Subjects;
import com.example.testbriz.repository.SubjectsRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
public class SubjectsService {
    private final SubjectsRepository subjectsRepository;

    public List<SubjectsResponseDto> getAll() {
        return subjectsRepository.findAll().stream().map(
                subjects -> SubjectsResponseDto.builder()
                        .subjectName(subjects.getSubjectName())
                        .build()
        ).collect(Collectors.toList());
    }

    public void addNewSubject(SubjectsRequestDto subjectsRequestDto){
        Subjects insertNewSubject = Subjects.builder()
                .subjectName(subjectsRequestDto.getSubjectName())
                .build();
        subjectsRepository.save(insertNewSubject);
    }
}
