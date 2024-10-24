package com.jt.security_jwt.service;

import com.jt.security_jwt.dto.StudentRequest;
import com.jt.security_jwt.model.Student;

public interface StudentService {

    Student addStudent(Student student);

    String login(StudentRequest request);

}
