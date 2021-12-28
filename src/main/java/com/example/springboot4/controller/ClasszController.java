package com.example.springboot4.controller;

import com.example.springboot4.repository.IClasszRepository;
import com.example.springboot4.service.ClasszService;
import com.example.springboot4.service.IClasszService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/classzs")
public class ClasszController {
//    @Autowired
//    IClasszService
}
