package com.example.taskapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TaskCreateDTO(
        @Size(min = 3, max = 50, message = "title must be between 3 and 50 characters") @NotBlank(message = "title must not be blank") String title,
        @NotNull(message = "completed must not be null") Boolean completed
) {}