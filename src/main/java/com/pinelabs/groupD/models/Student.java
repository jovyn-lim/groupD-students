package com.pinelabs.groupD.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
//    private enum status{
//        ACTIVE, INACTIVE
//    }
    private LocalDate dob;

    private String email;

    @Transient
    private Integer age;
    private Float lat;
    private Float lon;
    private String address;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    public Student() {
    }

    public Student(Long id, String name, LocalDate dob, String email, Integer age, Float lat, Float lon, String address, LocalDateTime createdOn, LocalDateTime modifiedOn) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public Student(String name, LocalDate dob, String email, Integer age, Float lat, Float lon, String address, LocalDateTime createdOn, LocalDateTime modifiedOn) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.lat = lat;
        this.lon = lon;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears() ;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", Email='" + email + '\'' +
                ", age=" + age +
                ", lat=" + lat +
                ", lon=" + lon +
                ", address='" + address + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                '}';

}

}



