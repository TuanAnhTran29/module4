package com.service.bookservice;

import com.model.Book;
import com.repo.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepo bookRepo;

    @Override
    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public void update(Book book) {
        bookRepo.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public void create(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Optional<Book> findByBookName(String bookName) {
        return bookRepo.findByBookName(bookName);
    }
}
