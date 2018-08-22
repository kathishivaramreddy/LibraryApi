package com.example.LibraryRestApi;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String bookName;
    private String authorName;

    public Book(){}

    public Book(String bookName,String authorName){
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString(){
        return "Books Id: " + id
                +"bookName : " + bookName
                +"authorName : " + authorName;
    }
}
