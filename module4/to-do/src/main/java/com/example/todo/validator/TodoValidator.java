package com.example.todo.validator;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
@Component
public class TodoValidator {
    public boolean isValid(Todo todo){
        return Optional.ofNullable(todo)
                .filter(t -> !StringUtils.isEmpty(t.getTitle()))
                .filter(t -> !StringUtils.isEmpty(t.getDetail()))
                .isPresent();
    }
}
