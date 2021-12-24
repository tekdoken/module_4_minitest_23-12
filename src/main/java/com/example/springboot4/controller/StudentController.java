package com.example.springboot4.controller;

import com.example.springboot4.model.Classz;
import com.example.springboot4.model.Student;
import com.example.springboot4.service.IClasszService;
import com.example.springboot4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    IStudentService iStudentService;
    @Autowired
    IClasszService iClasszService;

    @ModelAttribute("classzs")
    public Iterable<Classz> classzs() {
        return iClasszService.findAll();
    }

    @GetMapping("")
    public String list(Model model, String search) {
        Iterable<Student> studentPage = null;
        if (search == null) {
            studentPage = iStudentService.findAllByOrderByScoreAsc();
        } else {
            studentPage = iStudentService.findByNameContaining(search);
        }
        model.addAttribute("students", studentPage);
        return "list";
    }

    @GetMapping("edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<Student> studentOptional = iStudentService.findById(id);
        modelAndView.addObject("student", studentOptional.get());
        return modelAndView;
    }

    @PostMapping("edit")
    public String edit(Student student) {
        iStudentService.save(student);
        return "redirect:/";
    }

    @GetMapping("score8")
    public String ScoreGreater8(Model model) {
        Iterable<Student> studentPage;
        studentPage = iStudentService.findByScoreGreaterThanEqual(8);
        model.addAttribute("back","back");
        model.addAttribute("students", studentPage);
        return "list";
    }
}

