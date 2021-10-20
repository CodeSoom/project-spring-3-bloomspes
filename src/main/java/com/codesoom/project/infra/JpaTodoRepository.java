package com.codesoom.project.infra;


import com.codesoom.project.domain.Todo;
import com.codesoom.project.domain.TodoRepository;
import com.codesoom.project.valueobject.TodoData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JpaTodoRepository extends TodoRepository, CrudRepository<Todo, Long> {
    @Override
    List<Todo> find();

    @Override
    Optional<Todo> findById(Long id);

    @Override
    Todo save(TodoData task);

    @Override
    void delete(Todo task);
}
