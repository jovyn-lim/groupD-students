package com.pinelabs.groupD.services;

import com.pinelabs.groupD.models.Student;
import com.pinelabs.groupD.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
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

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("This email is taken");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        student.setCreatedOn(LocalDateTime.now().format(formatter));
        student.setModifiedOn(LocalDateTime.now().format(formatter));

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(
                    "Student with ID " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public String updateStudent(Long studentId, String email, String address) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student with ID " + studentId + " does not exist"));

        String returnMessage = null;

        if (email != null && email.length() > 0 ) {
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if (studentByEmail.isPresent()) {
                returnMessage = "This email is taken";
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                student.setModifiedOn(LocalDateTime.now().format(formatter));
                student.setEmail(email);
                returnMessage = "Email has been updated";
            }
        } else {
            returnMessage = "Invalid email";
        }


        if (address != null && address.length() > 0 && !Objects.equals(student.getAddress(), address)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            student.setModifiedOn(LocalDateTime.now().format(formatter));
            student.setAddress(address);
            returnMessage = returnMessage.concat( "\nAddress has been updated");
        } else if (Objects.equals(student.getAddress(), address)) {
            returnMessage = returnMessage.concat( "\nThis address has been previously recorded");
        }
        return returnMessage;
    }
}

