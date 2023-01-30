package com.dunky.in21hours.controllers;

import com.dunky.in21hours.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MyController {

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return Arrays.asList(new Book(2l, "Mastering Spring REST", "Dunky Opiyo"));
    }

}
