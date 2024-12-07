package com.projectSystem.projectSystem.controller.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projectSystem.projectSystem.model.Project;
import com.projectSystem.projectSystem.model.Task;
import com.projectSystem.projectSystem.model.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProjectDTO {
    private Integer id;
    private String name;
    private String description;
    private Project.Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    List<Task> tasks = new ArrayList<>();
    private UserEntity user;

}
