package com.graphql.controller;

import com.graphql.entity.Books;
import com.graphql.service.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;


    @MutationMapping("createBook")
    public Books createBook(@Argument  BookInput books){
        Books books1 = new Books();
        books1.setTitle(books.getTitle());
        books1.setBookName(books.getBookName());
        books1.setAuthor(books.getAuthor());
        books1.setPrice(books.getPrice());
        books1.setPages(books.getPages());
        return this.bookService.create(books1);
    }
    @QueryMapping("allBooks")
    public List<Books> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @QueryMapping("getBook")
    public Books getBookById(@Argument int id){
        return this.bookService.getBookById(id);
    }


}
@Getter
@Setter
class BookInput{
    private String bookName;
    private String title;
    private String author;
    private double price;
    private int pages;
}
