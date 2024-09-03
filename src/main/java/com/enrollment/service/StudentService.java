package com.enrollment.service;

import com.enrollment.entity.Student;
import com.enrollment.entity.Subject;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long studentId);

    Student addStudent(Student student, Long courseId);

    Optional<Student> updateStudentById(Long studentId, Student student);

    void deleteStudentById(Long studentId);

    void deleteAllStudents();
}
