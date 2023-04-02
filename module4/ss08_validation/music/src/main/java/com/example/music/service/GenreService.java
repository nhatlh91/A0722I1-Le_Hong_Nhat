package com.example.music.service;

import com.example.music.model.Genre;
import com.example.music.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface GenreService {
    List<Genre> findAll();

    void create(Genre genre);

    void update(Genre genre);

    Genre findById(Long id);

    void deleteById(Long id);
}
