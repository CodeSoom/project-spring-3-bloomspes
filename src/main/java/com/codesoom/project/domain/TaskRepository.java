package com.codesoom.project.domain;

import com.codesoom.project.vo.NewTask;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> find();

    Optional<Task> findById(Long id);

    Task save(NewTask task);

    void delete(Task task);
}
