package com.pinelabs.groupDstudents.student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String name;
    private boolean status;
    private Integer age;
    private static LocalDateTime created_on;
    private static LocalDateTime modified_on;



}
