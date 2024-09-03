package com.enrollment.dto;

import com.enrollment.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private String name;

    private List<Course> courseList;
}
