package com.pinelabs.groupD.services;

import com.pinelabs.groupD.Repository.StudentRepository;
import com.pinelabs.groupD.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        boolean exist = studentRepository.existsById(studentId);
        if (!exist){
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        return studentRepository.findStudentById(studentId);
    }


    public String addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("This email has been previously recorded");
        };
        student.setCreatedOn(LocalDateTime.now());
        student.setModifiedOn(LocalDateTime.now());

        studentRepository.save(student);

        return "Successfully added student";

    }

    public String deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist){
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
        return "Student successfully deleted";

    }
    @Transactional
    public String updateStudent(Long studentId,
                                String email,
                                String address) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"));
        String returnMessage;

                if (email != null &&
                    email.length() > 0 &&
                    !Objects.equals(student.getEmail(), email)){

                    Optional<Student> studentByEmail = studentRepository
                            .findStudentByEmail(email);
                    if (studentByEmail.isPresent()) {
                        throw new IllegalStateException("This email has been previously recorded");
                    }

                    else{

                        student.setModifiedOn(LocalDateTime.now());
                        student.setEmail(email);
                        returnMessage = "Email has been updated";}
                    }
                else {
                    returnMessage = "Invalid email";
                }
            if (address != null &&
                address.length() > 0 &&
                !Objects.equals(student.getAddress(), address)) {

                student.setModifiedOn(LocalDateTime.now());
                student.setAddress(address);
                returnMessage = returnMessage.concat( "\nAddress has been updated");

        } else if (Objects.equals(student.getAddress(), address)) {
            returnMessage = returnMessage.concat( "\nThis address has been previously recorded");
        }
        return returnMessage;






    }
}

