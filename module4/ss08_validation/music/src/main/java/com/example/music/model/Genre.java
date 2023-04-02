package com.example.music.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;

    @Size(max=100, message = "{genre.size}")
    @NotBlank(message = "{genre.blank}")
    @Pattern(regexp = "^[a-zA-Z0-9 ,]*$", message = "{special.symbol}")
    @Column(columnDefinition = "varchar(100)")
    private String genreName;
    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Song> songs;
}
