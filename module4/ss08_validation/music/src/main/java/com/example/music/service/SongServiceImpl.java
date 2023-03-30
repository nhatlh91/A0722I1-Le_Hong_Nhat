package com.example.music.service;

import com.example.music.model.Song;
import com.example.music.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    SongRepository repository;

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Song> search(String keyword, Pageable pageable) {
        return repository.findAllByNameContainingOrArtistContaining(keyword, keyword, pageable);
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
