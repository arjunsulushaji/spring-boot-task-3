package com.arjunshaji.spring.session.controller;

import com.arjunshaji.spring.session.entity.Student;
import com.arjunshaji.spring.session.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Object saveStudent(@RequestBody Student student){
            studentService.saveStudent(student);
            return "STUDENT DETAILS ADDED SUCCESSFULLY..........";
    }

    @GetMapping("/get/{id}")
    public Object getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Object updateStudentById(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudentById(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudentById(id);
    }
}
