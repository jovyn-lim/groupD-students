package com.pinelabs.groupD.controllers;

import com.pinelabs.groupD.models.Student;
import com.pinelabs.groupD.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public String registerNewStudents(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        return studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public String updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String address) {
        return studentService.updateStudent(studentId, email, address);
    }
}
