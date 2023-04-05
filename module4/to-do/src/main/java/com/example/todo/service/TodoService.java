package com.example.todo.service;

import com.example.todo.model.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> findAll(Integer limit);
    public Todo add(Todo todo);
}
