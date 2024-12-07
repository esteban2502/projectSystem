package com.projectSystem.projectSystem.service.interfaces;

import com.projectSystem.projectSystem.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Integer id);
    void addTask(Task task);
    void updatedTask(Integer id, Task updatedTask);
    void deletedTaskById(Integer id);
}
