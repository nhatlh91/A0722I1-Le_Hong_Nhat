package com.example.librarymanagement.controller;

import com.example.librarymanagement.exception.RentException;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Rent;
import com.example.librarymanagement.service.BookService;
import com.example.librarymanagement.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    RentService rentService;

    @GetMapping("/")
    public String showBooks(Pageable pageable, Model model){
        Page<Book> books = bookService.findAll(pageable);
        model.addAttribute("books",books);
        return "index";
    }

    @GetMapping("/rent")
    public String showRentForm(@RequestParam("id") Long book_id, Model model){
        Book book = bookService.findById(book_id);
        Rent rent = new Rent();
        rent.setBook(book);
        rent.generateCode();
        rent.setDate(new Date(System.currentTimeMillis()));
        model.addAttribute("rent",rent);
        return "rent";
    }

    @PostMapping("/rent")
    public String saveRentInfor(@Valid @ModelAttribute("rent") Rent rent, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "rent";
        }
        rentService.create(rent);
        Book book = bookService.findById(rent.getBook().getId());
        book.decreaseQuantity();
        bookService.save(book);
        return "redirect:/";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("rentCode") String rentCode){
        Rent rent = rentService.findByRentCode(rentCode);
        if(rent == null){
            throw new RentException("Mã mượn sách không đúng");
        }
        Book book = bookService.findById(rent.getBook().getId());
        book.increaseQuantity();
        rentService.delete(rent);
        return "redirect:/";
    }

    @ExceptionHandler(RentException.class)
    public String exceptionHandlerMethod(Model model, RentException ex){
        model.addAttribute("message",ex.getMessage());
        return "error";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("book",new Book());
        return "add";
    }

    @PostMapping("/add")
    public String addABook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add";
        }
        bookService.save(book);
        return "redirect:/";
    }
}
