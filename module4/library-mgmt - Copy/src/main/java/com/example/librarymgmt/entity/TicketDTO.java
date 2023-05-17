package com.example.librarymgmt.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class TicketDTO {
    private String ticketCode;
    private String bookName;
    private String bookAuthor;
    private String studentName;
    private String studentClass;
    private Date borrowDate;
    private Date returnDate;
}
