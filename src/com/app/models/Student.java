package com.app.models;

import java.util.Set;

public class Student {
    private Integer studentId;
    private String name;
    private String lastName;
    private int age;
    private Set<Course> courses;

    public Student() {}

    public Student(Integer studentId, String name, String lastName, int age, Set<Course> courses) {
        this.studentId = studentId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.courses = courses;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student = { Id: " + studentId + ", Name: '" + name + "', Last name: '" + lastName + "', Age: " + age + ", Courses = " + courses + " }";
    }
}
