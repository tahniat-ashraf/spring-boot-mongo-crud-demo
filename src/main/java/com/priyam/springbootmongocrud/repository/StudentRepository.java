package com.priyam.springbootmongocrud.repository;

import com.priyam.springbootmongocrud.dto.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {


}
