package com.priyam.springbootmongocrud.service;


import com.priyam.springbootmongocrud.dto.Student;
import com.priyam.springbootmongocrud.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;


    @Test
    public void getStudentList() {

        Mockito.when(
                studentRepository.findAll()
        ).thenReturn(List.of(getDemoStudent()));

        var studentList = studentService.findAll();

        assert studentList.get(0).getId() == 1;

    }

    @Test
    public void addStudent() {

        var student = getDemoStudent();

        Mockito.when(
                studentRepository.save(student)
        ).thenReturn(student);


        var student1 = studentService.addStudent(student);

    }

    @Test
    public void getStudent() {

        var student = getDemoStudent();

        Mockito.when(
                studentRepository.findById(1)
        ).thenReturn(Optional.of(student));

        var studentById = studentService.getStudentById(1);


        System.out.println("studentById.get().getFirstName() = " + studentById.get().getFirstName());
    }

    @Test
    public void removeStudent() {

        var student = getDemoStudent();

        Assertions.assertDoesNotThrow(() -> studentService.removeStudent(student));
    }

    private Student getDemoStudent() {

        return Student.builder()
                .id(1)
                .firstName("Tahniat")
                .lastName("Ashraf")
                .build();
    }
}
