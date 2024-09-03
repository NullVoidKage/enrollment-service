package com.enrollment.service;

import com.enrollment.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAllSubjects();

    Optional<Subject> getSubjectById(Long subjectId);

    Subject addSubject(Subject subject, Long courseId);

    Optional<Subject> updateSubject(Subject subject, Long subjectId);

    void deleteSubjectById(Long subjectId);

    void deleteAllSubject();


}
