package com.ys.studentmanager.entity;

public class Student {
    private String name;
    private String id;
    private int age;
    private String sex;
    private Course course;

    public Student(String name, String id, int age, String sex) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.sex = sex;
    }
    public Student(){

    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
