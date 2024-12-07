package com.projectSystem.projectSystem.controller.DTO;


import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String email,
                               @NotBlank String password) {
}
