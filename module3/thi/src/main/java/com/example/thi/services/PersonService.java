package com.example.thi.services;

import com.example.thi.models.Person;
import com.example.thi.repos.IPersonRepo;
import com.example.thi.repos.PersonRepo;

import java.util.List;

public class PersonService implements IPersonService{
    private IPersonRepo personRepo = new PersonRepo();
    @Override
    public void create(Person person) {

    }

    @Override
    public List<Person> read(int fid) {
        return personRepo.read(fid);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }
}
