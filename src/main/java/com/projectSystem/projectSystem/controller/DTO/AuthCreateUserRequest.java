package com.projectSystem.projectSystem.controller.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AuthCreateUserRequest(
                                @NotBlank String name,
                                @NotBlank String email,
                                @NotBlank String password,
                                @Valid AuthCreateRoleRequest roleRequest
                             ) {
}
