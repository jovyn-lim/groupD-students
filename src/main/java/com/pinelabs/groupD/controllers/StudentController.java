package com.pinelabs.groupD.controllers;

import com.pinelabs.groupD.models.Student;
import com.pinelabs.groupD.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();

    }
    @GetMapping(path = "{studentId}")
    public Optional<Student> getStudentById(

        @PathVariable("studentId")Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public void registerNewStudent(
            @RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
                studentService.updateStudent(studentId, name, email);
    }



}
