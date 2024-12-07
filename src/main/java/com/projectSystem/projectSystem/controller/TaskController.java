package com.projectSystem.projectSystem.controller;


import com.projectSystem.projectSystem.controller.DTO.TaskDTO;
import com.projectSystem.projectSystem.model.Task;
import com.projectSystem.projectSystem.service.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<?>  getALL(){
        List<TaskDTO> taskList = taskService.getAllTasks()
                .stream().map(task -> TaskDTO.builder()
                        .id(task.getId())
                        .name(task.getName())
                        .description(task.getDescription())
                        .status(task.getStatus())
                        .startDate(task.getStartDate())
                        .endDate(task.getEndDate())
                        .project(task.getProject())
                        .build()).toList();

        return ResponseEntity.ok(taskList);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<Task> taskOptional = taskService.getTaskById(id);

        if(taskOptional.isPresent()){
            Task task  = taskOptional.get();

            TaskDTO taskDTO = TaskDTO.builder()
                    .id(task.getId())
                    .name(task.getName())
                    .description(task.getDescription())
                    .status(task.getStatus())
                    .startDate(task.getStartDate())
                    .endDate(task.getEndDate())
                    .project(task.getProject())
                    .build();

            return ResponseEntity.ok(taskDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/task")
    public ResponseEntity<?> addTask(@RequestBody TaskDTO taskDTO){
        if(taskDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        taskService.addTask(Task.builder()
                .name(taskDTO.getName())
                .description(taskDTO.getDescription())
                .status(taskDTO.getStatus())
                .startDate(taskDTO.getStartDate())
                .endDate(taskDTO.getEndDate())
                .project(taskDTO.getProject()).build());

        return ResponseEntity.ok(taskDTO);
    }

    @PutMapping("/task/{id}")
    public  ResponseEntity<?> updatedTask(@PathVariable Integer id, @RequestBody TaskDTO taskDTO){

       Optional<Task>  taskOptional =  taskService.getTaskById(id);

       if(taskOptional.isPresent()){
           Task task = taskOptional.get();

           task.setName(taskDTO.getName());
           task.setDescription(taskDTO.getDescription());
           task.setStatus(taskDTO.getStatus());
           task.setStartDate(taskDTO.getStartDate());
           task.setEndDate(taskDTO.getEndDate());
           task.setProject(taskDTO.getProject());

           taskService.updatedTask(id,task);

           return  ResponseEntity.ok("El Registro se Actualizo Correctamente");


       }

       return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if(id!= null){
            taskService.deletedTaskById(id);
            return ResponseEntity.ok("Se elimino el registro correctamente");
        }

        return ResponseEntity.badRequest().build();
    }

}
