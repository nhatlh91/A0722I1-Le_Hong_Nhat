package com.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int comtId;
    private int rate;
    private String comment;
    private String author;
    private Date date;


    public Comment() {
    }

    public Comment(int comtId, int rate, String comment, String author,Date date) {
        this.comtId = comtId;
        this.rate = rate;
        this.comment = comment;
        this.author = author;
        this.date = date;
    }

    public int getComtId() {
        return comtId;
    }

    public void setComtId(int comtId) {
        this.comtId = comtId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
