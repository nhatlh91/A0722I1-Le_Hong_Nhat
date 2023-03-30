package com.example.music.service;

import com.example.music.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SongService {
    Page<Song> findAll(Pageable pageable);
    Page<Song> search(String keyword, Pageable pageable);
    Optional<Song> findById(Long id);
    void save(Song song);
    void delete(Long id);
}
