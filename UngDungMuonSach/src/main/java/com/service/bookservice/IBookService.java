package com.service.bookservice;

import com.model.Book;
import com.repo.IBookRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Iterable<Book> findAll();

    void update(Book book);

    Optional<Book> findById(Long id);

    void create(Book book);

    void remove(Long id);

    Optional<Book> findByBookName(String bookName);
}
