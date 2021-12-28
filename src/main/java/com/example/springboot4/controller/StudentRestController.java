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
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IClasszService iClasszService;


    @GetMapping("/list")
    public ResponseEntity<Iterable<Student>> list() {
        Iterable<Student> students = iStudentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/listClass")
    public ResponseEntity<Iterable<Classz>> listClass() {
        Iterable<Classz> students = iClasszService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Student>> s(@PathVariable Long id) {
        return new ResponseEntity<>(iStudentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id){
        iStudentService.remote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/sc8")
    public ResponseEntity<Iterable<Student>> ScoreGreater8(){
        Iterable<Student> students = iStudentService.findByScoreGreaterThanEqual(8);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("findByName/{key}")
    public ResponseEntity<Iterable<Student>> findByName(@PathVariable String key){
        Iterable<Student> students= iStudentService.findByNameContaining(key);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
}