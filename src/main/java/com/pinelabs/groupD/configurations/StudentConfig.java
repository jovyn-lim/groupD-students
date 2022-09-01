package com.pinelabs.groupD.configurations;

import com.pinelabs.groupD.models.Student;
import com.pinelabs.groupD.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student jovyn = new Student(
                    "Jovyn",
                    Student.StudentStatus.ACTIVE,
                    LocalDate.of(1980, JANUARY, 01),
                    "apilearner@gmail.com",
                    "Happy Garden",
                    "2022-08-28 08:00:48",
                    "2022-08-28 08:30:00"
            );
            Student arul = new Student(
                    "Arul",
                    Student.StudentStatus.INACTIVE,
                    LocalDate.of(2020, FEBRUARY, 01),
                    "apiteacher@gmail.com",
                    "Sad Garden",
                    "2022-08-29 08:00:05",
                    "2022-08-29 18:30:00"
            );

            repository.saveAll(
                    Arrays.asList(jovyn, arul)
            );
        };
    }
}
