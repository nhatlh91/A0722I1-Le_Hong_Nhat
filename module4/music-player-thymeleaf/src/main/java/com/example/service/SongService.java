package com.example.service;

import com.example.model.Song;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class SongService implements ISongService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("select s from Song s").getResultList();
    }

    @Override
    public void save(Song song) {
        entityManager.persist(song);
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class, id);
    }

    @Override
    public void update(Song song) {
        entityManager.merge(song);

    }

    @Override
    public void remove(int id) {
        entityManager.remove(findById(id));
    }
}
