package com.example.thi.repos;

import com.example.thi.models.Family;

import java.util.List;

public interface IFamilyRepo {
    void create(Family family);
    List<Family> read();
    Family read(int fid);
    void update(Family family);
    void delete(Family family);
}
