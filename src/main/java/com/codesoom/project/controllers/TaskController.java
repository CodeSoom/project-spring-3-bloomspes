package com.codesoom.project.controllers;

import com.codesoom.project.application.TaskService;
import com.codesoom.project.domain.Task;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @CrossOrigin
    public List<Task> TodoList() {
        return taskService.getTasks();
    }

    @GetMapping("{id}")
    @CrossOrigin
    public List<Task> todo(@PathVariable Long id) {
        return TaskService.getTask(id);
    }
    
}
