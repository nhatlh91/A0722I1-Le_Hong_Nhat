package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    private int id;
    private String name;
    private String artist;
    private String type;
    private String url;

    public Song() {
    }

    public Song(int id, String name, String artist, String type, String url) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String email) {
        this.artist = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String address) {
        this.type = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + artist + '\'' +
                ", address='" + type + '\'' +
                '}';
    }
}
