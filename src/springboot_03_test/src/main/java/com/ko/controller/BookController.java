package com.ko.controller;

import com.ko.pojo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Komorebi
 * @since 2022.11.27.13:54
 */
@RestController
@RequestMapping("/books")
public class BookController {

    /* @GetMapping
    public String getById(){
        System.out.println("getById is running...");
        return "spring boot";
    } */

    @GetMapping
    public Book getById(){
        System.out.println("getById is running...");
        Book book = new Book();
        book.setId(1);
        book.setName("222");
        book.setType("333");
        book.setDescription("5555");
        return book;
    }
}
