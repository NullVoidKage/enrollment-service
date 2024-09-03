package com.enrollment.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses") // Match the `Student` side
    private List<Student> students;

    @OneToMany(mappedBy = "course")
    private List<Subject> subjects;

}
