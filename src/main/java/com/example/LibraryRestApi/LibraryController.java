package com.example.LibraryRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getbookdetails")
    public List<Book> getBookDetails(){

       return bookService.findAll();

    }

    @GetMapping("/getbookdetails/{bookid}")
    public Book getBookDetailsById(@PathVariable Long bookid) throws BookNotFoundException {
        Optional<Book> book = bookService.findById(bookid);
        if (!book.isPresent())
                throw new BookNotFoundException("id-" + bookid);
        return book.get();
    }

    @GetMapping("/totalcount")
    public Long getBookCount(){

        return bookService.getBookCount();

    }

    @GetMapping("/getbookdetails/{bookName}")
    public Book getBookDetails(@PathVariable String bookName) throws BookNotFoundException {

           Book book = bookService.findByBookName(bookName);
            return book;
    }

    @DeleteMapping("/deletebook/{bookid}")
    public void deleteById(@PathVariable Long bookid){

        bookService.deleteById(bookid);

    }

    @PostMapping("/addbooks")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {

        Book savedBook = bookService.save(book);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedBook.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

}
