package com.enrollment.controller;

import com.enrollment.entity.Course;
import com.enrollment.entity.Student;
import com.enrollment.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable("courseId") Long courseId) {
        return new ResponseEntity<>(courseService.findCourseById(courseId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Course> addCourse(@Valid @RequestBody Course courseBody) {
        return new ResponseEntity<>(courseService.addCourse(courseBody), HttpStatus.CREATED);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Optional<Course>> updateCourse(@PathVariable("courseId") Long courseId,
                                                           @Valid @RequestBody Course courseBody) {
        return new ResponseEntity<>(courseService.updateCourseById(courseBody, courseId), HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourseById(@PathVariable("courseId, ") Long courseId) {
        courseService.deleteCourseById(courseId);
        return new ResponseEntity<>("Successfully deleted " + courseId, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllCourse() {
        courseService.deleteAllCourse();
        return new ResponseEntity<>("Successfully deleted all subject/s", HttpStatus.OK);
    }
}
