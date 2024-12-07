package com.projectSystem.projectSystem.repository;

import com.projectSystem.projectSystem.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task,Integer> {
}
