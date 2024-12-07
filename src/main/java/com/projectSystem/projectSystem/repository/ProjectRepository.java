package com.projectSystem.projectSystem.repository;

import com.projectSystem.projectSystem.controller.DTO.StatusDTO;
import com.projectSystem.projectSystem.controller.DTO.numTasksByProjectDTO;
import com.projectSystem.projectSystem.model.Project;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer> {

    @Query("SELECT p FROM Project p WHERE p.user.id = :id")
    public List<Project> findProjectByUserId(@Param("id")  Integer id);


    @Query("SELECT p FROM Project p WHERE p.user.id = :id AND p.status = 'ACTIVO' ")
    public List<Project> findProjectByUserIdStatus(@Param("id")  Integer id);

    @Query("SELECT p.status AS status , count(p) AS num FROM Project p WHERE p.user.id = :id GROUP BY p.status")
    public List<StatusDTO> countProjectsByStatus(@Param("id")  Integer id);

    @Query(value = "SELECT p.name AS name, COUNT(t.id) AS task " +
            "FROM tasks t " +
            "RIGHT JOIN projects p ON p.id = t.id_project " +
            "WHERE p.id_user = :userId  AND t.status = 'PENDIENTE' " +
            "GROUP BY p.name",
            nativeQuery = true)
    public List<numTasksByProjectDTO> countTasksByProject(@Param("userId") Integer id);
}




