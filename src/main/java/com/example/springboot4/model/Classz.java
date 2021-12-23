package com.example.springboot4.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Classz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String name;
    @OneToMany(targetEntity = Student.class)
    private List<Student> students;

    public Classz() {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Classz(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
}
