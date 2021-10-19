package com.codesoom.project.application;

import com.codesoom.project.domain.Task;
import com.codesoom.project.domain.TaskRepository;
import com.codesoom.project.errors.TaskNotFoundException;
import com.codesoom.project.vo.NewTask;
import com.github.dozermapper.core.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {
    private final Mapper mapper;
    private final TaskRepository taskRepository;

    public TaskService(
            Mapper mapper,
            TaskRepository taskRepository
    ) {
        this.mapper = mapper;
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.find();
    }

    public List<Task> getTask(Long id) {
        return findTask(id);
    }

    public Task createTask(NewTask newTask) {
        Task task = mapper.map(newTask, Task.class);

        return TaskRepository.save(task);
    }

    public Task updateTask(Long id, NewTask newTask) {
        Task task = findTask(id);
        task.changeData(mapper.map(newTask, Task.class));

        return task;
    }

    public Task deleteTask(Long id) {
        Task task = findTask(id);
        taskRepository.delete(task);

        return task;
    }

    private Task findTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
}
