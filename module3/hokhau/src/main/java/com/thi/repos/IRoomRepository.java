package com.thi.repos;

import com.thi.model.Room;

import java.util.List;

public interface IRoomRepository {
    void create(Room room);
    List<Room> read();
    Room read(int id);
    void update(Room room);
    void detele(int id);
    List<Room> search(String keyword);
}
