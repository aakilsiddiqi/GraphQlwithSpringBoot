package com.graphql.service;

import com.graphql.entity.Books;
import com.graphql.repo.BookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Books create(Books book) {
        return this.bookRepo.save(book);
    }

    @Override
    public List<Books> getAllBooks() {
        return this.bookRepo.findAll();
    }

    @Override
    public Books getBookById(int id) {
        return this.bookRepo.findById(id).orElseThrow(()->new RuntimeException("No Books Found for This ID !!!!"));
    }
}
