package com.example.librarymgmt.controller;

import com.example.librarymgmt.entity.Book;
import com.example.librarymgmt.entity.Student;
import com.example.librarymgmt.entity.Ticket;
import com.example.librarymgmt.entity.TicketDTO;
import com.example.librarymgmt.service.BookServiceImpl;
import com.example.librarymgmt.service.StudentServiceImpl;
import com.example.librarymgmt.service.TicketServiceImpl;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/tickets/")
public class TicketController {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private TicketServiceImpl ticketService;

    @GetMapping("list")
    public String showTicketList(Model model) {
        List<Ticket> tickets = ticketService.findAllActive();
        if(!tickets.isEmpty()){
            model.addAttribute("tickets",tickets);
        } else {
            String message = "Không có lịch sử muon sách được ghi nhận";
            model.addAttribute("message",message);
        }
        return "ticket/list";
    }

    @GetMapping("return")
    public String issueABook(@RequestParam("ticketId") Long ticketId, RedirectAttributes rd) {
        Ticket ticket = ticketService.findById(ticketId);
        ticket.setTicketStatus(true);
        ticketService.save(ticket);

        Book book = ticket.getBook();
        book.increaseQty();
        bookService.save(book);

        String message = "Trả sách thành công";
        rd.addFlashAttribute("message",message);
        return "redirect:/books/list";
    }

    @GetMapping("search")
    public String searchTicket(@RequestParam(value = "bookName", required = false) String bookName,
                               @RequestParam(value = "studentName", required = false) String studentName,
                               Model model){
        if(bookName!=null){
            List<Ticket> resultSet = new ArrayList<>();
            List<Book> books = bookService.findByBookName(bookName);
            for (Book book:books){
               Set<Ticket> tickets = book.getTickets();
               resultSet.addAll(tickets);
            }
        }
        return "ticket/list";
    }
}
