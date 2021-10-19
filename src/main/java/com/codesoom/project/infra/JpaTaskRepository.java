package com.codesoom.project.infra;


import com.codesoom.project.domain.Task;
import com.codesoom.project.domain.TaskRepository;
import com.codesoom.project.vo.NewTask;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JpaTaskRepository extends TaskRepository, CrudRepository<Task, Long> {
    List<Task> find();

    Optional<Task> findById(Long id);

    Task save(NewTask task);

    void delete(Task task);
}
