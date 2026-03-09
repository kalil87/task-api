package com.example.taskapp.dto;

public record TaskResponseDTO(
        Long id,
        String title,
        Boolean completed
) { }