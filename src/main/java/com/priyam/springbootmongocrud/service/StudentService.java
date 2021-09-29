package com.priyam.springbootmongocrud.service;

import com.priyam.springbootmongocrud.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Student addStudent(Student student);

    Optional<Student> getStudentById(int id);

    void removeStudent(Student student);
}
