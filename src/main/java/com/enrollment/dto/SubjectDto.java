package com.enrollment.dto;

import com.enrollment.entity.Course;
import lombok.Data;

@Data
public class SubjectDto {
    private String name;
    private Course course;
}
