package com.controller;

import com.model.Book;
import com.model.LoanCard;
import com.repo.IBookRepo;
import com.service.bookservice.BookService;
import com.service.bookservice.IBookService;
import com.service.loancardservice.ILoanCardService;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private ILoanCardService loanCardService;


    @GetMapping("showBook")
    public ModelAndView showBookList(){
        ModelAndView modelAndView= new ModelAndView("view");
        Iterable<Book> books= bookService.findAll();
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @GetMapping("showCreateForm")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("book",new Book());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView createBook(@ModelAttribute Book book){
        ModelAndView modelAndView= new ModelAndView("view");
        bookService.create(book);
        modelAndView.addObject("books",bookService.findAll());
        modelAndView.addObject("message","Book created successfully");
        return modelAndView;
    }

    @GetMapping("view-detail")
    public ModelAndView view(@RequestParam("id") Optional<Book> book){
        ModelAndView modelAndView= new ModelAndView("view_detail");
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @PostMapping("borrowBook")
    public ModelAndView borrowBook(@RequestParam("id") Book book){
        ModelAndView modelAndView = new ModelAndView("view");
        if (book.getQuantity() ==0) {
            ModelAndView modelAndView1= new ModelAndView("error");
            return modelAndView1;
        }else {
            book.setQuantity(book.getQuantity() - 1);
            bookService.update(book);
            Random rnd = new Random();
            int number = rnd.nextInt(99999);
            List<Integer> existCode= loanCardService.findAllCode();
            while (existCode.contains(number)){
                number = rnd.nextInt(99999);
            }
            LoanCard loanCard= new LoanCard(number,book.getBookName());
            loanCardService.create(loanCard);
            modelAndView.addObject("books",bookService.findAll());
            modelAndView.addObject("message","Book borrowed successfully, your loan card code is: " + number);
            return modelAndView;
        }

    }

    @GetMapping("returnBook")
    public ModelAndView showReturnForm(){
        ModelAndView modelAndView= new ModelAndView("returnbook");
        modelAndView.addObject("loanCard",new LoanCard());
        return modelAndView;
    }

    @PostMapping("return")
    public ModelAndView returnBook(@ModelAttribute LoanCard loanCard){
        ModelAndView modelAndView= new ModelAndView("view");
        Optional<LoanCard> loanCard1= loanCardService.findByCode(loanCard.getCode());
        if (!loanCard1.isPresent()) {
            ModelAndView modelAndView1= new ModelAndView("error2");
            return modelAndView1;
        }else {
            Optional<Book> book= bookService.findByBookName(loanCard.getBookName());
            book.get().setQuantity(book.get().getQuantity() + 1);
            bookService.update(book.get());
            loanCardService.remove(loanCardService.findByCode(loanCard.getCode()).get().getId());
            modelAndView.addObject("books",bookService.findAll());
            return modelAndView;
        }
    }


}
