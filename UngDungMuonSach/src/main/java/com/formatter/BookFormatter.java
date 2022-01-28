package com.formatter;

import com.model.Book;
import com.service.bookservice.IBookService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class BookFormatter implements Formatter<Book> {
    private IBookService bookService;

    public BookFormatter(IBookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public Book parse(String text, Locale locale) throws ParseException {
        Optional<Book> book= bookService.findById(Long.parseLong(text));
        return book.orElse(null);
    }

    @Override
    public String print(Book object, Locale locale) {
        return "[" + object.getId() + ", " +object.getBookName() + "]";
    }
}
