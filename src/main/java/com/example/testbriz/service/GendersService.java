package com.example.testbriz.service;

import com.example.testbriz.dto.AuditoryResponseDto;
import com.example.testbriz.dto.GendersResponseDto;
import com.example.testbriz.repository.AuditorysRepository;
import com.example.testbriz.repository.GendersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class GendersService {
    private final GendersRepository gendersRepository;

    public List<GendersResponseDto> getAll() {
        return gendersRepository.findAll().stream().map(
                genders -> GendersResponseDto.builder()
                        .genderName(genders.getGenderName())
                        .build()
        ).collect(Collectors.toList());
    }
}
