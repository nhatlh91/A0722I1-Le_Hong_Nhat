package com.example.librarymgmt.service;


import com.example.librarymgmt.entity.Student;
import com.example.librarymgmt.entity.Ticket;
import com.example.librarymgmt.repository.StudentRepository;
import com.example.librarymgmt.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class TicketServiceImpl implements Service<Ticket>{
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
    public List<Ticket> findAllActive() {
        return ticketRepository.findAllByTicketStatus(false);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }
    public Ticket findByCode(String ticketCode) {
        return ticketRepository.findByTicketCode(ticketCode).orElse(null);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

}

