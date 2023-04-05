package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.validator.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TodoValidator todoValidator;

    @Override
    public List<Todo> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> todoRepository.findAll());
    }

    @Override
    public Todo add(Todo todo) {
        return todoValidator.isValid(todo) ? todoRepository.save(todo) : null;
    }
}
