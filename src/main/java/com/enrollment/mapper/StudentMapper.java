package com.enrollment.mapper;


import com.enrollment.dto.StudentDto;
import com.enrollment.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto studentDto(Student student);

    Student student(StudentDto studentDto);
}
