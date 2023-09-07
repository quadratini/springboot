package com.luv2code.cruddemo.controllers;

import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.exceptions.StudentErrorResponse;
import com.luv2code.cruddemo.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students = new ArrayList<>();

    // define @PostConstruct to load the student data only once
    @PostConstruct
    public void loadData() {
        students.add(new Student("Mickey", "Mouse", "mickeymouse@disney.com"));
        students.add(new Student("Minnie", "Mouse", "minniemouse@disney.com"));
        students.add(new Student("Donald", "Duck", "donaldduck@disney.com"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // check the studentId again list size
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student Id is not found - " + studentId);
        }
        return students.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
