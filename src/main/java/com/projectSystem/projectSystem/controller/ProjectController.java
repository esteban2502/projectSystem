package com.projectSystem.projectSystem.controller;

import com.projectSystem.projectSystem.controller.DTO.ProjectDTO;
import com.projectSystem.projectSystem.controller.DTO.StatusDTO;
import com.projectSystem.projectSystem.controller.DTO.numTasksByProjectDTO;
import com.projectSystem.projectSystem.model.Project;
import com.projectSystem.projectSystem.model.UserEntity;
import com.projectSystem.projectSystem.service.interfaces.ProjectService;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@CrossOrigin("*")
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping("/projects")
    public ResponseEntity<?> getAllProjects(){
        List<ProjectDTO> projectList = projectService.getAll()
                .stream()
                .map(project -> ProjectDTO.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .description(project.getDescription())
                        .status(project.getStatus())
                        .startDate(project.getStartDate())
                        .endDate(project.getEndDate())
                        .tasks(project.getTasks())
                        .build())
                .toList();
        return ResponseEntity.ok(projectList);

    }

    @GetMapping("/project/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Optional<Project> projectOptional = projectService.getProjectById(id);
        if(projectOptional.isPresent()){
            Project project = projectOptional.get();

            ProjectDTO projectDTO = ProjectDTO.builder()
                    .id(project.getId())
                    .name(project.getName())
                    .description(project.getDescription())
                    .status(project.getStatus())
                    .startDate(project.getStartDate())
                    .endDate(project.getEndDate())
                    .tasks(project.getTasks()).build();

            return ResponseEntity.ok(projectDTO);

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/project")
    public ResponseEntity<?> addProject(@RequestBody ProjectDTO projectDTO) throws URISyntaxException {
        if (projectDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
    projectService.addProject(Project.builder()
            .name(projectDTO.getName())
            .description(projectDTO.getDescription())
            .status(projectDTO.getStatus())
            .startDate(projectDTO.getStartDate())
            .endDate(projectDTO.getEndDate())
            .user(projectDTO.getUser())
            .build());

        return ResponseEntity.created(new URI("/project")).build();
    }


    @PutMapping("/project/{id}")
    public ResponseEntity<?> updateProject(@PathVariable Integer id, @RequestBody ProjectDTO projectDTO ){
        Optional<Project> projectOptional = projectService.getProjectById(id);

        if(projectOptional.isPresent()){
            Project project = projectOptional.get();
            project.setName(projectDTO.getName());
            project.setDescription(projectDTO.getDescription());
            project.setStatus(projectDTO.getStatus());
            project.setStartDate(projectDTO.getStartDate());
            project.setEndDate(projectDTO.getEndDate());
            project.setUser(projectDTO.getUser());

            projectService.updateProject(id,project);

            return ResponseEntity.ok("Registro Actualizado Correctamente");
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/project/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if(id!=null){
            projectService.deleteProjectById(id);
            return ResponseEntity.ok("Registro Eliminado Correctamente");
        }
        return  ResponseEntity.badRequest().build();
    }

    @GetMapping("/projects/user/{id}")
    public  ResponseEntity<?> getProjectByUser(@PathVariable Integer id){
        List<ProjectDTO> projectList = projectService.getAllByUser(id)
                .stream()
                .map(project -> ProjectDTO.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .description(project.getDescription())
                        .status(project.getStatus())
                        .startDate(project.getStartDate())
                        .endDate(project.getEndDate())
                        .tasks(project.getTasks())
                        .build())
                .toList();
        return ResponseEntity.ok(projectList);
    }

    @GetMapping("/projects/active/user/{id}")
    public ResponseEntity<?> getProjectByUserStatus(@PathVariable Integer id){
        List<ProjectDTO> projectList = projectService.getAllByUserStatus(id)
                .stream()
                .map(project -> ProjectDTO.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .description(project.getDescription())
                        .status(project.getStatus())
                        .startDate(project.getStartDate())
                        .endDate(project.getEndDate())
                        .tasks(project.getTasks())
                        .build())
                .toList();
        return ResponseEntity.ok(projectList);
    }



    @GetMapping("/projects/count/user/{id}")
    public ResponseEntity<?> countProjectsByStatus(@PathVariable Integer id){
        List<StatusDTO> list = projectService.countProjectsByStatus(id);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/projects/tasks/user/{id}")
    public ResponseEntity<?> countTasksByProject(@PathVariable Integer id){
        List<numTasksByProjectDTO> list =  projectService.countTasksByProject(id);

        return  ResponseEntity.ok(list);
    }
}



