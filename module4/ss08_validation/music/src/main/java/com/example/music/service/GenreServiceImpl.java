package com.example.music.service;

import com.example.music.model.Genre;
import com.example.music.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreServiceImpl implements GenreService{
    @Autowired
    GenreRepository genreRepository;
    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public void create(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void update(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }
}
