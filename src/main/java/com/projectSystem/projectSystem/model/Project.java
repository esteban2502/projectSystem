package com.projectSystem.projectSystem.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="projects")
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(max = 150)
    private String name;
    @NotNull
    private String description;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @JsonManagedReference
    @OneToMany( mappedBy = "project",fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    List<Task> tasks = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "idUser")
    @JsonBackReference
    private UserEntity user;


    public enum Status{
        ACTIVO,
        PENDIENTE,
        COMPLETADO,
        CANCELADO
    }




}

