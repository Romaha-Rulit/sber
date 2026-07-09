package com.sber.model;

public class Student {
    private final String name;
    private final int age;
    private final int course;

    public Student(String name, int age, int course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", course=" + course + "}";
    }
}
