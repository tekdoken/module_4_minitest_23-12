package com.example.springboot4.repository;

import com.example.springboot4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository <Student,Long> {
//    Page<Student> findAll(Pageable pageable);
    Iterable<Student> findByNameContaining(String name);
    Iterable<Student> findAllByOrderByScoreAsc();
    Iterable<Student> findByScoreGreaterThanEqual(int score);
}
