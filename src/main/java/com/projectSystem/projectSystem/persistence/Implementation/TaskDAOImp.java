package com.projectSystem.projectSystem.persistence.Implementation;

import com.projectSystem.projectSystem.model.Task;
import com.projectSystem.projectSystem.repository.TaskRepository;
import com.projectSystem.projectSystem.persistence.interfaces.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TaskDAOImp implements TaskDAO {

    @Autowired
    private TaskRepository repository;


    @Override
    public List<Task> getAllTasks() {
        Iterable<Task> tasks = repository.findAll();
        List<Task> list = new ArrayList<>();
        for(Task aux : tasks){
            list.add(aux);
        }
        return list;
    }

    @Override
    public Optional<Task> getTaskById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void addTask(Task task) {
        repository.save(task);

    }

    @Override
    public void updatedTask(Integer id, Task updatedTask) {
        updatedTask.setId(id);
        repository.save(updatedTask);
    }

    @Override
    public void deletedTaskById(Integer id) {
        repository.deleteById(id);
    }
}
