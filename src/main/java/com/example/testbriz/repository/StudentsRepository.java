package com.example.testbriz.repository;

import com.example.testbriz.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository  extends JpaRepository<Students, Integer> {
Students deleteById(int id);

}
