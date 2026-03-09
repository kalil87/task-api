package com.example.taskapp.mapper;

import com.example.taskapp.dto.TaskCreateDTO;
import com.example.taskapp.dto.TaskResponseDTO;
import com.example.taskapp.model.Task;

import java.util.List;

public class TaskMapper {
    public static Task toEntity(TaskCreateDTO dto) {

        Task task = new Task();

        task.setTitle(dto.title());
        task.setCompleted(dto.completed());

        return task;
    }

    public static TaskResponseDTO toDTO(Task task) {

        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getCompleted()
        );
    }

    public static List<TaskResponseDTO> toDTOList(List<Task> tasks) {

        return tasks.stream()
                .map(TaskMapper::toDTO)
                .toList();
    }
}
