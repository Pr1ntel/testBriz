package com.example.testbriz.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teachers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patonymic_name")
    private String patronymicName;

    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Genders genders;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subjects subjects;


}
