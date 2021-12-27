package com.example.springboot4.controller;

import com.example.springboot4.model.Classz;
import com.example.springboot4.model.Student;
import com.example.springboot4.service.IClasszService;
import com.example.springboot4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IClasszService iClasszService;


    @GetMapping("/students")
    public ResponseEntity<Iterable<Student>> list() {
        Iterable<Student> students = iStudentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> s(@PathVariable Long id) {
        Optional<Student> students = iStudentService.findById(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Student>> edit(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> studentOptional = iStudentService.findById(id);
        student.setId(studentOptional.get().getId());
        iStudentService.save(student);
        return new ResponseEntity<>(studentOptional, HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Student> save(@RequestBody Student student) {
       iStudentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id){
        iStudentService.remote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}