package com.projectSystem.projectSystem.service.implementation;

import com.projectSystem.projectSystem.model.Task;
import com.projectSystem.projectSystem.persistence.interfaces.TaskDAO;
import com.projectSystem.projectSystem.service.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService {


    @Autowired
    private TaskDAO taskDAO;

    @Override
    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @Override
    public Optional<Task> getTaskById(Integer id) {
        return taskDAO.getTaskById(id);
    }

    @Override
    public void addTask(Task task) {
    taskDAO.addTask(task);
    }

    @Override
    public void updatedTask(Integer id, Task updatedTask) {
    taskDAO.updatedTask(id, updatedTask);
    }

    @Override
    public void deletedTaskById(Integer id) {
    taskDAO.deletedTaskById(id);
    }
}
