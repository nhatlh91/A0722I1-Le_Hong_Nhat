package com.example.librarymgmt.validator;


import com.example.librarymgmt.entity.Ticket;
import com.example.librarymgmt.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;


@Component
public class TicketValidator implements Validator {
    @Autowired
    private TicketServiceImpl ticketService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Ticket)) {
            return;
        }
        Ticket ticket = (Ticket) target;

        if (ticket.getTicketCode() == null) {
            errors.rejectValue("ticketCode", "create.nullId","Mã số không thể để trống");
        }

        if (ticketService.findByCode(ticket.getTicketCode()) != null) {
            errors.rejectValue("ticketCode", "create.duplicateId", new String[]{ticket.getTicketCode()},"Mã số bị trùng lặp");
        }

        if (!ticket.getTicketCode().matches("^MS-\\d{4}$")) {
            errors.rejectValue("ticketCode", "create.wrong-pattern", new String[]{ticket.getTicketCode()},"Mã số không đúng quy định, phải là MS-xxxx");
        }

        if (ticket.getReturnDate().compareTo(ticket.getBorrowDate())<0) {
            errors.rejectValue("returnDate", "returnDate", new Date[]{ticket.getReturnDate()},"Ngày trả không thể trước ngày mượn");
        }
    }
}
