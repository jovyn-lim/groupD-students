package com.pinelabs.groupD.services;

import com.pinelabs.groupD.exceptions.StudentNotFoundException;
import com.pinelabs.groupD.models.Student;
import com.pinelabs.groupD.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            throw new StudentNotFoundException();
        }
        return optionalStudent.get();
    }

    public Student addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("This email is taken");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        student.setCreatedOn(LocalDateTime.now().format(formatter));
        student.setModifiedOn(LocalDateTime.now().format(formatter));

        return studentRepository.save(student);
    }

    public Student deleteStudent(Long studentId) {

        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            throw new StudentNotFoundException();
        }
        studentRepository.deleteById(studentId);

        return optionalStudent.get();
    }

    @Transactional
    public Student updateStudent(Long studentId, String name, Student.StudentStatus status, String email, String address) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            throw new StudentNotFoundException();
        }
        Student student = optionalStudent.get();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        student.setModifiedOn(LocalDateTime.now().format(formatter));
        student.setName(name);
        student.setStatus(status);
        student.setEmail(email);
        student.setAddress(address);
        return this.studentRepository.save(student);
    }
}

