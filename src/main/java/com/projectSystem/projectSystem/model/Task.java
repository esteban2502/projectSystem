package com.projectSystem.projectSystem.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name="tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 100)
    @NotNull
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
    @ManyToOne
    @JoinColumn(name = "idProject")
    @JsonBackReference
    private Project project;

    public enum Status{

        PENDIENTE,
        COMPLETADA,

    }

}
