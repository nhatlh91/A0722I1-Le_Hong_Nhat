package com.example.thi.services;

import com.example.thi.models.Person;

import java.util.List;

public interface IPersonService {
    void create(Person person);
    List<Person> read(int fid);
    void update(Person person);
    void delete(Person person);
}
