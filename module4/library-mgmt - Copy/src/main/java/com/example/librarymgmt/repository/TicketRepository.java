package com.example.librarymgmt.repository;

import com.example.librarymgmt.entity.Book;
import com.example.librarymgmt.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findAllByTicketStatus(boolean status);
    Optional<Ticket> findByTicketCode(String ticketCode);

    List<Ticket> findAllByBookContains(Book[] books);
}
