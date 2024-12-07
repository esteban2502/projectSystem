package com.projectSystem.projectSystem.persistence.Implementation;

import com.projectSystem.projectSystem.controller.DTO.StatusDTO;
import com.projectSystem.projectSystem.controller.DTO.numTasksByProjectDTO;
import com.projectSystem.projectSystem.model.Project;
import com.projectSystem.projectSystem.repository.ProjectRepository;
import com.projectSystem.projectSystem.persistence.interfaces.ProjectDAO;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProjectDAOImp implements ProjectDAO {

    @Autowired
    private ProjectRepository repository;

    @Override
    public List<Project> getAll() {
        Iterable<Project> projects = repository.findAll();
        ArrayList<Project> list = new ArrayList<>();
        for(Project aux : projects){
            list.add(aux);
        }
        return list;
    }

    @Override
    public Optional<Project> getProjectById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void addProject(Project project) {
        repository.save(project);
    }

    @Override
    public void updateProject(Integer id, Project updateProject) {
        updateProject.setId(id);
        repository.save(updateProject);
    }

    @Override
    public void deleteProjectById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Project> getAllByUser(Integer id) {
         Iterable<Project> projects = repository.findProjectByUserId(id);
        ArrayList<Project> list = new ArrayList<>();
        for(Project aux : projects){
            list.add(aux);
        }
        return list;
    }

    @Override
    public List<Project> getAllByUserStatus(Integer id) {
        return repository.findProjectByUserIdStatus(id);
    }

    @Override
    public List<StatusDTO> countProjectsByStatus(Integer id) {
        return repository.countProjectsByStatus(id);
    }

    @Override
    public List<numTasksByProjectDTO> countTasksByProject(Integer id) {
        return repository.countTasksByProject(id);
    }
}
