package com.enrollment.service;

import com.enrollment.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourse();

    Optional<Course> findCourseById(Long courseId);

    Course addCourse(Course course);

    Optional<Course> updateCourseById(Course course, Long courseId);

    void deleteCourseById(Long courseId);

    void deleteAllCourse();
}
