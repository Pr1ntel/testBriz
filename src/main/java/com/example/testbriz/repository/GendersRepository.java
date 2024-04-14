package com.example.testbriz.repository;

import com.example.testbriz.model.Genders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GendersRepository  extends JpaRepository<Genders, Integer> {

}
