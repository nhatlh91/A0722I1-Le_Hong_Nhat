package com.example.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class MyFile implements Serializable {
    private static final long serialVersionUID = 1L;
    private MultipartFile multipartFile;
    private String description;

    public MyFile() {
    }

    public MyFile(MultipartFile multipartFile, String description) {
        this.multipartFile = multipartFile;
        this.description = description;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
