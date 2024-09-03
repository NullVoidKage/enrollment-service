package com.enrollment.mapper;


import com.enrollment.dto.CourseDto;
import com.enrollment.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto courseToDto(Course course);

    Course course(CourseDto courseDto);
}
