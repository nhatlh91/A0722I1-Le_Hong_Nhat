package com.example.thi.services;

import com.example.thi.models.Family;
import com.example.thi.repos.FamilyRepo;
import com.example.thi.repos.IFamilyRepo;

import java.util.List;

public class FamilyService implements IFamilyService{
    private IFamilyRepo familyRepo = new FamilyRepo();
    @Override
    public void create(Family person) {
familyRepo.create(person);
    }

    @Override
    public List<Family> read() {
        return familyRepo.read();
    }

    @Override
    public Family read(int fid) {
        return familyRepo.read(fid);
    }

    @Override
    public void update(Family family) {
    familyRepo.update(family);
    }

    @Override
    public void delete(Family family) {
    familyRepo.delete(family);
    }
}
