package com.codesoom.project.errors;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task is not founded " + id);
    }
}
