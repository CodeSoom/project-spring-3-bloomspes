package com.codesoom.project.application;

import com.codesoom.project.domain.Todo;
import com.codesoom.project.domain.TodoRepository;
import com.codesoom.project.errors.TodoNotFoundException;
import com.codesoom.project.valueobject.TodoData;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {
    private final Mapper mapper;
    private final TodoRepository todoRepository;

    public TodoService(Mapper mapper, TodoRepository todoRepository) {
        this.mapper = mapper;
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodoList() {
        return todoRepository.find();
    }

    public Todo getTodo(Long id) {
        return findTodo(id);
    }

    private Todo findTodo(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Todo createTodo(TodoData todoData) {
        Todo todo = mapper.map(todoData, Todo.class);
        return todoRepository.save(todo);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Todo updateTodo(Long id, TodoData todoData) {
        Todo todo = findTodo(id);
        todo.changeData(mapper.map(todoData, Todo.class));

        return todo;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Todo deleteTodo(Long id) {
        Todo todo = findTodo(id);
        todoRepository.delete(todo);

        return todo;
    }
}
