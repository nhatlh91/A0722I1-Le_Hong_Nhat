package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class TodoController {
    @Autowired
    TodoService todoService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String todoList(Model model, @RequestParam(value = "limit", required = false) Integer limit){
        List<Todo> todoList = todoService.findAll(limit);
        model.addAttribute("todoList",todoList);
        return "list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String add(Model model){
        Todo todo = new Todo();
        model.addAttribute("todo",todo);
        return "create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String add(@ModelAttribute("todo") Todo todo){
        todoService.add(todo);
        return "redirect:/list";
    }

}
