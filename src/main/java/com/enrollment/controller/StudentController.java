package com.enrollment.controller;

import com.enrollment.entity.Course;
import com.enrollment.entity.Student;
import com.enrollment.entity.Subject;
import com.enrollment.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(studentService.getStudentById(studentId),
                HttpStatus.OK);
    }

    @PostMapping("/{courseId}")
    public ResponseEntity<Student> addStudent(@PathVariable("courseId") Long courseId,
                                              @Valid @RequestBody Student studentBody) {
        return new ResponseEntity<>(studentService.addStudent(studentBody, courseId),
                HttpStatus.CREATED);

    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Optional<Student>> updateStudent(@PathVariable("studentId") Long studentId,
                                                           @Valid @RequestBody Student studentBody) {
        return new ResponseEntity<>(studentService.updateStudentById(studentId,
                studentBody), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>("Successfully deleted " + studentId,
                HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllSubject() {
        studentService.deleteAllStudents();
        return new ResponseEntity<>("Successfully deleted all subject/s",
                HttpStatus.OK);
    }
}
