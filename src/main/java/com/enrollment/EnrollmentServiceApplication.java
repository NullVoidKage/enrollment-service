package com.enrollment;

import com.enrollment.entity.Course;
import com.enrollment.entity.Student;
import com.enrollment.entity.Subject;
import com.enrollment.repository.CourseRepository;
import com.enrollment.repository.StudentRepository;
import com.enrollment.repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EnrollmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollmentServiceApplication.class, args);
	}


}
