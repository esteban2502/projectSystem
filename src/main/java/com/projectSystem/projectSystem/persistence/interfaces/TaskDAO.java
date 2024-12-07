package com.projectSystem.projectSystem.persistence.interfaces;

import com.projectSystem.projectSystem.model.Task;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public interface TaskDAO {

    List<Task> getAllTasks();
    Optional<Task> getTaskById(Integer id);
    void addTask(Task task);
    void updatedTask(Integer id, Task updatedTask);
    void deletedTaskById(Integer id);

}
