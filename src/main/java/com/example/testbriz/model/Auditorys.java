package com.example.testbriz.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auditorys")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auditorys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "year_of_study")
    private int yearOfStudy;

    @Column(name = "auditory_name")
    private String auditoryName;

    @ManyToOne
    @JoinColumn(name = "classroom_teacher_id")
    private Teachers teachers;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subjects subjects;

    @ManyToOne
    @JoinColumn(name = "students_id")
    private Students students;
}
