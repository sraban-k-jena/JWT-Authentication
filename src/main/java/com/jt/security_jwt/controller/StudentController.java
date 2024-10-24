package com.jt.security_jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.security_jwt.dto.StudentRequest;
import com.jt.security_jwt.model.Student;
import com.jt.security_jwt.repository.StudentRepo;
import com.jt.security_jwt.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    @Autowired
    public StudentService service;

    @GetMapping("/")
    public ResponseEntity<?> getDetails(HttpServletRequest request) {
        String id = request.getSession().getId();
        return new ResponseEntity<>("Id name is :" + id, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student Stduent) {
        Student student2 = service.addStudent(Stduent);
        return new ResponseEntity<>(student2, HttpStatus.CREATED);
    }

    @PostMapping("/log")
    public ResponseEntity<?> login(@RequestBody StudentRequest request) {
        String login = service.login(request);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

}
