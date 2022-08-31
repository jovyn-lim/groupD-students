package com.pinelabs.groupD.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String name;

//    private StudentStatus status;
//    public enum StudentStatus {
//        ACTIVE,
//        INACTIVE;
//    }
//    public boolean isActive() {
//        if (getStatus() == StudentStatus.ACTIVE) {
//            return true;
//        }
//        return false;
//    }
    private LocalDate dob;
    @Transient
    private Integer age;
    private String email;
    private String address;
    private String createdOn;
    private String modifiedOn;

    public Student() {
    }

    public Student(Long id, String name, LocalDate dob, String email, String address, String createdOn, String modifiedOn) {
        this.id = id;
        this.name = name;
        //this.status = status;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public Student(String name, LocalDate dob, String email, String address, String createdOn, String modifiedOn) {
        this.name = name;
        //this.status = status;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public StudentStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(StudentStatus status) {
//        this.status = status;
//    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {

        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", status=" + status +
                ", dob=" + dob +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", modifiedOn='" + modifiedOn + '\'' +
                '}';
    }
}

