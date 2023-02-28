package com.example.thi.repos;

import com.example.thi.models.Person;

import java.util.List;

public interface IPersonRepo {
    void create(Person person);
    List<Person> read(int fid);
    void update(Person person);
    void delete(Person person);
}
