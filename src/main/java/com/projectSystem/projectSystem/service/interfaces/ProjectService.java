package com.projectSystem.projectSystem.service.interfaces;

import com.projectSystem.projectSystem.controller.DTO.StatusDTO;
import com.projectSystem.projectSystem.controller.DTO.numTasksByProjectDTO;
import com.projectSystem.projectSystem.model.Project;
import jakarta.persistence.Tuple;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface ProjectService {
    List<Project> getAll();
    Optional<Project> getProjectById(Integer id);
    void addProject(Project project);
    void updateProject(Integer id, Project updateProject);
    void deleteProjectById(Integer id);
    List<Project> getAllByUser(Integer id);
    List<Project>  getAllByUserStatus(Integer id);
    public List<StatusDTO> countProjectsByStatus(Integer id);
    List<numTasksByProjectDTO> countTasksByProject(Integer id);

}
