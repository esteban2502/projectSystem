package com.projectSystem.projectSystem.service.implementation;

import com.projectSystem.projectSystem.controller.DTO.StatusDTO;
import com.projectSystem.projectSystem.controller.DTO.numTasksByProjectDTO;
import com.projectSystem.projectSystem.model.Project;
import com.projectSystem.projectSystem.persistence.interfaces.ProjectDAO;
import com.projectSystem.projectSystem.service.interfaces.ProjectService;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImp  implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;


    @Override
    public List<Project> getAll() {
        return projectDAO.getAll();
    }

    @Override
    public Optional<Project> getProjectById(Integer id) {
        return projectDAO.getProjectById(id);
    }

    @Override
    public void addProject(Project project) {
        projectDAO.addProject(project);
    }

    @Override
    public void updateProject(Integer id, Project updateProject) {
        projectDAO.updateProject(id, updateProject);
    }

    @Override
    public void deleteProjectById(Integer id) {
        projectDAO.deleteProjectById(id);
    }

    @Override
    public List<Project> getAllByUser(Integer id) {
        return projectDAO.getAllByUser(id);
    }

    @Override
    public List<Project> getAllByUserStatus(Integer id) {
        return projectDAO.getAllByUserStatus(id);
    }

    @Override
    public List<StatusDTO> countProjectsByStatus(Integer id) {
        return projectDAO.countProjectsByStatus(id);
    }

    @Override
    public List<numTasksByProjectDTO> countTasksByProject(Integer id) {
        return projectDAO.countTasksByProject(id);
    }
}
