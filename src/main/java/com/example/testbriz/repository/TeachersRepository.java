package com.example.testbriz.repository;

import com.example.testbriz.model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository  extends JpaRepository<Teachers, Integer> {
    Teachers deleteById(int id);
}
