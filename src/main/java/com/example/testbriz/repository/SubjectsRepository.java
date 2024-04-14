package com.example.testbriz.repository;

import com.example.testbriz.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository  extends JpaRepository<Subjects, Integer> {
int deleteById(int id);
}
