package com.pinelabs.groupD.services;

import com.pinelabs.groupD.Repository.StudentRepository;
import com.pinelabs.groupD.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return StudentRepository.findAll();
    }
}
