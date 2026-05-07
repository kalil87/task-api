package com.example.taskapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @Size(min = 3, max = 12)
        @NotBlank
        String username,

        @Size(min = 8, max = 12)
        @NotBlank
        String password
) {}