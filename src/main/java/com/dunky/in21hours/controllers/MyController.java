package com.dunky.in21hours.controllers;

import com.dunky.in21hours.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

;

@RestController
public class MyController {

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return Arrays.asList(new Student(10001, "Geoffrey", "Kampala", new Date()));
    }

}
