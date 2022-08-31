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

    public Optional<Student> getStudentById(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        return studentRepository.findStudentById(studentId);
    }

    public String addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("This email is taken");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        student.setCreatedOn(LocalDateTime.now().format(formatter));
        student.setModifiedOn(LocalDateTime.now().format(formatter));

        studentRepository.save(student);

        return "Student successfully created";
    }

    public String deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(
                    "Student with ID " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);

        return "This student record was deleted";
    }

    @Transactional
    public String updateStudent(Long studentId, String name, String email, String address) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student with ID " + studentId + " does not exist"));

        String returnMessage = null;

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            student.setModifiedOn(LocalDateTime.now().format(formatter));
            student.setName(name);
            returnMessage = "Student name has been modified";
        }

        if (email != null && email.length() > 0 ) {
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if (studentByEmail.isPresent()) {
                returnMessage = returnMessage.concat("\nThis email is taken");
            } else if (email != student.getEmail()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                student.setModifiedOn(LocalDateTime.now().format(formatter));
                student.setEmail(email);
                returnMessage = returnMessage.concat("\nEmail has been updated");
            } else {
                returnMessage = returnMessage.concat("\nInvalid email");
            }
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

