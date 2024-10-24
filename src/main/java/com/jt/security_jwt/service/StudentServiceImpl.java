package com.jt.security_jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.jt.security_jwt.dto.StudentRequest;
import com.jt.security_jwt.model.Student;
import com.jt.security_jwt.repository.StudentRepo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepo studentRepo;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Override
    public Student addStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepo.save(student);
    }

    @Override
    public String login(StudentRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.Yn3uJSFcwFncUxfhWwHzUaLe3vnHsOVFjoLUktbx8zI";
        }
        return null;
    }

}
