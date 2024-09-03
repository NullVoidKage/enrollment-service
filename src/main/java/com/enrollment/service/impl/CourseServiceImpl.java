package com.enrollment.service.impl;

import com.enrollment.entity.Course;
import com.enrollment.repository.CourseRepository;
import com.enrollment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> updateCourseById(Course course, Long id) {
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    existingCourse.setName(course.getName());
                    return courseRepository.save(existingCourse);
                });
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteAllCourse() {
        courseRepository.deleteAll();
    }
}
