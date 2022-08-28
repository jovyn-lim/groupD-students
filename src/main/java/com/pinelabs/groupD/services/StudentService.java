package com.pinelabs.groupD.services;

import com.pinelabs.groupD.models.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return Arrays.asList(
                new Student(
                        001L,
                        "Jovyn",
                        LocalDate.of(1996, Month.SEPTEMBER, 18),
                        18,
                        00.00F,
                        11.11F,
                        "Happy Garden",
                        LocalDateTime.of(2022, Month.AUGUST, 28, 8, 00, 48),
                        LocalDateTime.of(2022, Month.AUGUST, 28, 8,30, 00)
                )
        );
    }
}
