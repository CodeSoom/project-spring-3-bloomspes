package com.codesoom.project.controllers;

import com.codesoom.project.application.TodoService;
import com.codesoom.project.domain.Todo;
import com.codesoom.project.valueobject.TodoData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> TodoList() {
        return todoService.getTodoList();
    }

    @GetMapping("/{id}")
    public Todo todo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody TodoData todoData) {
        return todoService.createTodo(todoData);
    }

    @PatchMapping("{id}")
    public Todo patchTodo(@PathVariable Long id, @RequestBody TodoData todoData) {
        return todoService.updateTodo(id, todoData);
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
    
}
