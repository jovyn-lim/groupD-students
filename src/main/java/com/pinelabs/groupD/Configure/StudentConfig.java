package com.pinelabs.groupD.Configure;


import com.pinelabs.groupD.Repository.StudentRepository;
import com.pinelabs.groupD.models.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class StudentConfig {

    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Jovyn = new Student(
                    "Jovyn",
                    LocalDate.of(2020,Month.AUGUST,22),
                    18,
                    121.12F,
                    121.12F,

                    "Happy Garden",
                    LocalDateTime.of(2022, Month.AUGUST, 28, 8, 00, 48),
                    LocalDateTime.of(2022, Month.AUGUST, 28, 8,30, 00)
            );
            Student Arul = new Student(
                    "Arul",
                    LocalDate.of(2020,Month.AUGUST,22),
                    24,
                    121.12F,
                    121.11F,
                    "Kl",
                    LocalDateTime.of(2022, Month.AUGUST, 28, 8, 00, 48),
                    LocalDateTime.of(2022, Month.AUGUST, 28, 8,30, 00)
            );

            repository.saveAll(
                    Arrays.asList(Jovyn, Arul)
            );
        };
    }
}
