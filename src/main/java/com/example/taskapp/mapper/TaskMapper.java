package com.example.taskapp.mapper;

import com.example.taskapp.dto.request.TaskRequestDTO;
import com.example.taskapp.dto.response.TaskResponseDTO;
import com.example.taskapp.entity.Task;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskResponseDTO toDTO(Task task);

    Task toEntity(TaskRequestDTO dto);
}