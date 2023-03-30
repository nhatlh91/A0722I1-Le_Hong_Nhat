package com.example.music.repository;

import com.example.music.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongRepository extends JpaRepository<Song,Long> {
    @Override
    Page<Song> findAll(Pageable pageable);
    Page<Song> findAllById(Pageable pageable, Long id);
    Page<Song> findAllByNameContainingOrArtistContaining(String name, String artist, Pageable pageable);

}
