package com.example.taskapp.mapper;

import com.example.taskapp.dto.TaskCreateDTO;
import com.example.taskapp.dto.TaskResponseDTO;
import com.example.taskapp.model.Task;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskResponseDTO toDTO(Task task);

    Task toEntity(TaskCreateDTO dto);
}