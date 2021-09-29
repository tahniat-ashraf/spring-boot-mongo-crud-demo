package com.priyam.springbootmongocrud.controller;

import com.priyam.springbootmongocrud.dto.Student;
import com.priyam.springbootmongocrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudentList() {

        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

}
