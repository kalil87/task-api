package com.example.taskapp.dto.response;

public record TaskResponseDTO(
        Long id,
        String title,
        Boolean completed
) { }