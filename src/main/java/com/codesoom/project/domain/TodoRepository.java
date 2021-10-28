package com.codesoom.project.domain;

import com.codesoom.project.valueobject.TodoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> find();

    Optional<Todo> findById(Long id);

    Todo save(TodoData task);

    void delete(Todo task);
}
