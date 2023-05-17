package com.example.librarymgmt.controller;

import com.example.librarymgmt.entity.Book;
import com.example.librarymgmt.entity.Student;
import com.example.librarymgmt.entity.Ticket;
import com.example.librarymgmt.service.BookServiceImpl;
import com.example.librarymgmt.service.StudentServiceImpl;
import com.example.librarymgmt.service.TicketServiceImpl;
import com.example.librarymgmt.validator.TicketValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books/")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private TicketServiceImpl ticketService;
    @Autowired
    private TicketValidator ticketValidator;

    @GetMapping("list")
    public String showBookList(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books",books);
        return "book/list";
    }

    @GetMapping("issue")
    public String issueABook(@RequestParam(value = "bookId",required = false) Long bookId,
                             @RequestParam(value = "bookQty",required = false) int bookQty,Model model) {
        if(bookQty==0){
            return "book/ran-out";
        }
        Book book = bookService.findById(bookId);
        List<Student> students = studentService.findAll();
        Ticket ticket = new Ticket();
        ticket.setBook(book);
        model.addAttribute("students",students);
        model.addAttribute("ticket",ticket);
        return "book/issue";
    }

    @PostMapping("issue")
    public String issueABook(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult bindingResult,Model model) {
        ticketValidator.validate(ticket,bindingResult);
        if(bindingResult.hasErrors()){
            List<Student> students = studentService.findAll();
            model.addAttribute("ticket",ticket);
            model.addAttribute("students",students);
            return "book/issue";
        }
        System.out.println(ticket.toString());
        ticketService.save(ticket);
        Book book = ticket.getBook();
        book.decreaseQty();
        bookService.save(book);
        return "redirect:/books/list";
    }
}
