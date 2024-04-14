package com.example.testbriz.repository;

import com.example.testbriz.model.Auditorys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditorysRepository  extends JpaRepository<Auditorys, Integer> {
Auditorys deleteById(int id);

}
