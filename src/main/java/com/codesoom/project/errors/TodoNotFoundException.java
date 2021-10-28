package com.codesoom.project.errors;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(Long id) {
        super("Todo list is not founded " + id);
    }
}
