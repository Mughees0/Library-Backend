package com.rest_api.fs14backend.controller;

import com.rest_api.fs14backend.dao.BookDao;
import com.rest_api.fs14backend.entity.Author;
import com.rest_api.fs14backend.entity.Category;
import com.rest_api.fs14backend.service.AuthorService;
import com.rest_api.fs14backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import com.rest_api.fs14backend.entity.Book;
import com.rest_api.fs14backend.service.BookService;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping("/add")
    public Book createOne(@RequestBody BookDao bookDao) {
        return bookService.createOne(bookDao);
    }

    @GetMapping("/{id}")
    public Book getOne(@PathVariable UUID id){
        return bookService.findOne(id);
    }
   @PutMapping("/update/{id}")
    public Book updateOne(@PathVariable UUID id,@RequestBody BookDao bookDao){
        return bookService.updateOne(id,bookDao);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOne(@PathVariable UUID id){
            bookService.deleteOne(id);
    }

}
