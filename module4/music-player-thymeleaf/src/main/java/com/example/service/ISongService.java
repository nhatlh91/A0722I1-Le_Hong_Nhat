package com.example.service;

import com.example.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void update(Song song);

    void remove(int id);
}
