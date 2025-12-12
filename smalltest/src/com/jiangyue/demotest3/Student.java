package com.jiangyue.demotest3;

import java.time.LocalDateTime;
import java.util.List;

public class Student {
    private long id;
    private String name;
    private String gender;
    private LocalDateTime selectDateTime;
    private List<String> selectLocations;

    public Student() {
    }

    public Student(long id, String name, String gender, LocalDateTime selectDateTime, List<String> selectLocations) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.selectDateTime = selectDateTime;
        this.selectLocations = selectLocations;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public LocalDateTime getSelectDateTime() {
        return selectDateTime;
    }
    public void setSelectDateTime(LocalDateTime selectDateTime) {
        this.selectDateTime = selectDateTime;
    }
    public List<String> getSelectLocations() {
        return selectLocations;
    }
    public void setSelectLocations(List<String> selectLocations) {
        this.selectLocations = selectLocations;
    }
}

