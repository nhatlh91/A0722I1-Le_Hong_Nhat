package com.example.music.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Setter
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genreId", referencedColumnName = "genreId")
    private Genre genre;

}
