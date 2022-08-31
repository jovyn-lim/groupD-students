package com.pinelabs.groupD.repositories;

import com.pinelabs.groupD.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentById(Long studentId);
    Optional<Student> findStudentByEmail(String email);
}
