package com.example.blog.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(10000)")
    private String content;
    @Column(columnDefinition = "varchar(100)")
    private String title;
    @Column(columnDefinition = "varchar(50)")
    private String author;
    private Date dateOfCreate;
    @ManyToOne()
    @JoinColumn(name="categoryId", referencedColumnName = "categoryId")
    private Category category;

    public Blog() {
    }

    public Blog(Long id, String content, String title, String author, Date dateOfCreate) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
        this.dateOfCreate = dateOfCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String summary) {
        this.title = summary;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Blog(Long id, String content, String title, String author, Date dateOfCreate, Category category) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
        this.dateOfCreate = dateOfCreate;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
