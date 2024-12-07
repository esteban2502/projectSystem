package com.projectSystem.projectSystem.controller.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.projectSystem.projectSystem.model.Project;
import com.projectSystem.projectSystem.model.Task;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskDTO {
    private Integer id;
    private String name;
    private String description;
    private Task.Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Project project;
}
