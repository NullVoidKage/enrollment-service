package com.enrollment.service.impl;

import com.enrollment.entity.Course;
import com.enrollment.entity.Student;
import com.enrollment.repository.CourseRepository;
import com.enrollment.repository.StudentRepository;
import com.enrollment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student addStudent(Student student, Long courseId) {
        Student saveStudent = studentRepository.save(student);
        Optional<Course> courseList = courseRepository.findById(courseId);
        if(courseList.isPresent()) {
            Course course = courseList.get();
            course.getStudents().add(saveStudent);
            courseRepository.save(course);
        }
        return saveStudent;
    }

    @Override
    public Optional<Student> updateStudentById(Long id, Student student) {
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setName(student.getName());
                    existingStudent.setCourses(student.getCourses());
                    return studentRepository.save(existingStudent);
                });
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
