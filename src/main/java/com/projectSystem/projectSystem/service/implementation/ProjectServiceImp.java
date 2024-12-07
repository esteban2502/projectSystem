package com.projectSystem.projectSystem.service.implementation;

import com.projectSystem.projectSystem.controller.DTO.StatusDTO;
import com.projectSystem.projectSystem.controller.DTO.numTasksByProjectDTO;
import com.projectSystem.projectSystem.exception.CanNotCreateException;
import com.projectSystem.projectSystem.exception.NotFoundException;
import com.projectSystem.projectSystem.model.Project;
import com.projectSystem.projectSystem.persistence.interfaces.ProjectDAO;
import com.projectSystem.projectSystem.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if(!projectDAO.getProjectById(id).isPresent()){
            throw new NotFoundException(
                    "no se encontro en la base de datos el proyecto con el id: "+id);
        }else{
            return projectDAO.getProjectById(id);
        }

    }

    @Override
    @Transactional
    public void addProject(Project project) {
        try{
            projectDAO.addProject(project);
        }catch (Exception e){
            throw new CanNotCreateException(e.getMessage());
        }

    }

    @Override
    @Transactional
    public void updateProject(Integer id, Project updateProject) {
        projectDAO.updateProject(id, updateProject);
    }

    @Override
    @Transactional
    public void deleteProjectById(Integer id) {
        if(!projectDAO.getProjectById(id).isPresent()){
          throw new NotFoundException
                  ("no se encuentro en la base de datos el proyecto con el id :" +id+
                  "no se puede eliminar");
        }else{
        projectDAO.deleteProjectById(id);
        }
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
