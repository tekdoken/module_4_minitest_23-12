package com.example.springboot4.service;

import com.example.springboot4.model.Student;
import com.example.springboot4.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository iStudentRepository;

    @Override
    public Iterable<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void remote(Long id) {
        iStudentRepository.deleteById(id);
    }


    @Override
    public Iterable<Student> findByNameContaining(String name) {
        return iStudentRepository.findByNameContaining(name);
    }

    @Override
    public Iterable<Student> findAllByOrderByAgeAsc() {
        return iStudentRepository.findAllByOrderByAgeAsc();
    }


    @Override
    public Iterable<Student> findByScoreGreaterThanEqual(int score) {
        return iStudentRepository.findByScoreGreaterThanEqual(score);
    }
}
