package com.pinelabs.groupD.controllers;

import com.pinelabs.groupD.models.Student;
import com.pinelabs.groupD.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(this.studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping(path = "{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable("studentId") Long studentId){
        return new ResponseEntity<>(this.studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registerNewStudents(@RequestBody Student student) {
        return new ResponseEntity<>(this.studentService.addNewStudent(student), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable("studentId") Long studentId){
        return new ResponseEntity<>(this.studentService.deleteStudent(studentId), HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity<?> updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = true) String name,
            @RequestParam(required = true) Student.StudentStatus status,
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String address) {
        return new ResponseEntity<>(this.studentService.updateStudent(studentId, name, status, email, address), HttpStatus.OK);
    }
}
