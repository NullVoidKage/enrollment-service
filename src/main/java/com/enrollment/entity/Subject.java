package com.enrollment.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
