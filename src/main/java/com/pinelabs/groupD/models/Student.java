package com.pinelabs.groupD.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    private Long id;
    private String name;
//    private enum status{
//        ACTIVE, INACTIVE
//    }
    private Integer age;
    private String address;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    public Student() {
    }

    public Student(Long id, String name, Integer age, String address, LocalDateTime createdOn, LocalDateTime modifiedOn) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public Student(String name, Integer age, String address, LocalDateTime createdOn, LocalDateTime modifiedOn) {
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
                ", age=" + age +
                ", address='" + address + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}

