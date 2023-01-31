package com.dunky.in21hours.controllers;

import com.dunky.in21hours.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

;

@RestController
public class MyController {

    @GetMapping("/persons")
    public List<Person> getAllBooks(){
        return Arrays.asList(new Person(10001, "Geoffrey", "Kampala", new Date("1988-05-05")));
    }

}
