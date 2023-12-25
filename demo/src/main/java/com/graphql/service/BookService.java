package com.graphql.service;

import com.graphql.entity.Books;

import java.util.List;

public interface BookService {
    //create
    Books create(Books book);
    //getAllBooks

    List<Books> getAllBooks();

    Books getBookById(int id);
}
