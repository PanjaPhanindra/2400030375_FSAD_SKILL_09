package com.klu.studentExceptionAPI.controller;
import com.klu.studentExceptionAPI.exception.InvalidInputException;
import com.klu.studentExceptionAPI.exception.StudentNotFoundException;
import com.klu.studentExceptionAPI.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        if(id < 0)
        {
            throw new InvalidInputException("Student ID cannot be negative");
        }

        if(id != 1)
        {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }

        return new Student(1,"Phanindra","CSE");
    }
}