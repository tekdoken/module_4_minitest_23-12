package com.example.springboot4.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int score;
    private int age;
    @ManyToOne
    @JoinColumn(name="class_id")
    private Classz classz;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Classz getClassz() {
        return classz;
    }

    public void setClassz(Classz classz) {
        this.classz = classz;
    }

    public Student() {
    }

    public Student(String name, int score, int age, Classz classz) {
        this.name = name;
        this.score = score;
        this.age = age;
        this.classz = classz;
    }
}
