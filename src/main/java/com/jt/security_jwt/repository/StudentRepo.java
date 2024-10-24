package com.jt.security_jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.security_jwt.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByUsername(String username);
}