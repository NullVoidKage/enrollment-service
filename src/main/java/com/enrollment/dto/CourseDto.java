package com.enrollment.dto;

import com.enrollment.entity.Student;
import com.enrollment.entity.Subject;
import lombok.Data;

import java.util.List;

@Data
public class   CourseDto {
    private String name;

    private List<Student> studentList;

    private List<Subject> subjectList;
}
