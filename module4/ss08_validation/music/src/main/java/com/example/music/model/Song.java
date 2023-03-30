package com.example.music.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max=800, message = "{name.size}")
    @NotBlank(message = "{name.blank}")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "{special.symbol}")
    @Column(columnDefinition = "varchar(800)")
    private String name;

    @Size(max=300, message = "{artist.size}")
    @NotBlank(message = "{artist.blank}")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "{special.symbol}")
    @Column(columnDefinition = "varchar(300)")
    private String artist;

    @Size(max=100, message = "{genre.size}")
    @NotBlank(message = "{genre.blank}")
    @Pattern(regexp = "^[a-zA-Z0-9 ,]*$", message = "{special.symbol}")
    @Column(columnDefinition = "varchar(100)")
    private String genre;

    public Song() {
    }

    public Song(Long id, String name, String artist, String genre) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
