package com.example.dictionary.service;

import com.example.dictionary.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Autowired
    DictionaryRepository repository;

    @Override
    public String search(String input) {
        return repository.search(input);
    }
}
