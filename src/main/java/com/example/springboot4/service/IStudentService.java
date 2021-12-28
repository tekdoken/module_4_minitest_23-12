package com.example.springboot4.service;


import com.example.springboot4.model.Student;

public interface IStudentService extends IGeneralService<Student> {
    Iterable<Student> findByNameContaining( String name);
    Iterable<Student> findAllByOrderByAgeAsc();
    Iterable<Student> findByScoreGreaterThanEqual(int score);
}
