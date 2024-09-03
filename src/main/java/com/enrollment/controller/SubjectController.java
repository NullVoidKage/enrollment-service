package com.enrollment.controller;

import com.enrollment.entity.Student;
import com.enrollment.entity.Subject;
import com.enrollment.service.SubjectService;
import com.enrollment.service.impl.SubjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatus.OK);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<Optional<Subject>> getSubjectById(@PathVariable("subjectId") Long subjectId) {
        return new ResponseEntity<>(subjectService.getSubjectById(subjectId),
                HttpStatus.OK);
    }

    @PostMapping("/{courseId}")
    public ResponseEntity<Subject> addSubject(@PathVariable("courseId") Long courseId,
                                              @Valid @RequestBody Subject subjectBody) {

        return new ResponseEntity<>(subjectService.addSubject(subjectBody, courseId), HttpStatus.CREATED);

    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<Optional<Subject>> updateSubject(@PathVariable("subjectId") Long subjectId,
                                                 @Valid @RequestBody Subject subjectBody) {
        return new ResponseEntity<>(subjectService.updateSubject(subjectBody, subjectId), HttpStatus.OK);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<String> deleteSubjectById(@PathVariable("courseId") Long id) {
        subjectService.deleteSubjectById(id);
        return new ResponseEntity<>("Successfully deleted " + id, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllSubject() {
        subjectService.deleteAllSubject();
        return new ResponseEntity<>("Successfully deleted all subject/s", HttpStatus.OK);
    }
}
