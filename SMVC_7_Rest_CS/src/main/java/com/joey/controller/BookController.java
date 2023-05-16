package com.joey.controller;

import com.joey.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @PostMapping
    public String save(@RequestBody Book b){
        System.out.println("book save =>"+b);
        return "{'module':'book save success'}";
    }

    @GetMapping
    public List<Book> getBooks(){
        ArrayList<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setDescription("abc");
        b1.setId(12);
        b1.setName("SpringMVC-Intro");
        b1.setType("Programming Books");

        Book b2 = new Book();
        b2.setDescription("xyz");
        b2.setId(2);
        b2.setName("SpringMVC-2");
        b2.setType("Programming Books");


        books.add(b1);
        books.add(b2);
        return books;
    }
}
