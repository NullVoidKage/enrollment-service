package com.enrollment.service.impl;

import com.enrollment.entity.Course;
import com.enrollment.entity.Subject;
import com.enrollment.mapper.SubjectMapper;
import com.enrollment.repository.CourseRepository;
import com.enrollment.repository.SubjectRepository;
import com.enrollment.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    private SubjectMapper subjectMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId);
    }

    @Override
    public Subject addSubject(Subject subject, Long courseId) {
        Subject saveSubject = subjectRepository.save(subject);

        Optional<Course> courses = courseRepository.findById(courseId);
        if(courses.isPresent()) {
            Course course = courses.get();
            course.getSubjects().add(saveSubject);
            courseRepository.save(course);
        }
        return saveSubject;
    }

    @Override
    public Optional<Subject> updateSubject(Subject subject, Long subjectId) {
        return subjectRepository.findById(subjectId)
                .map(existingSubject -> {
                    existingSubject.setName(subject.getName());
                    existingSubject.setCourse(subject.getCourse());
                    return subjectRepository.save(existingSubject);
                });
    }

    @Override
    public void deleteSubjectById(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

    @Override
    public void deleteAllSubject() {
        if(subjectRepository != null) {
            subjectRepository.deleteAll();

        }
    }
}
