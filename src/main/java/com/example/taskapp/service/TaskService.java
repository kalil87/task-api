package com.example.taskapp.service;

import com.example.taskapp.dto.TaskCreateDTO;
import com.example.taskapp.dto.TaskResponseDTO;
import com.example.taskapp.exception.TaskNotFoundException;
import com.example.taskapp.mapper.TaskMapper;
import com.example.taskapp.model.Task;
import com.example.taskapp.repository.TaskRepository;
import com.example.taskapp.util.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    private Task findTask(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(Message.TASK_NOT_FOUND));
    }

    public Page<TaskResponseDTO> getAll(Pageable pageable){
        return repository.findAll(pageable).map(TaskMapper::toDTO);
    }

    public TaskResponseDTO getById(Long id) {

        Task task = findTask(id);

        return TaskMapper.toDTO(task);
    }

    public TaskResponseDTO create(TaskCreateDTO dto) {

        Task task = TaskMapper.toEntity(dto);
        Task saved = repository.save(task);

        return TaskMapper.toDTO(saved);
    }

    public TaskResponseDTO update(Long id, TaskCreateDTO dto) {

        Task existing = findTask(id);

        existing.setTitle(dto.title());
        existing.setCompleted(dto.completed());

        Task updated = repository.save(existing);

        return TaskMapper.toDTO(updated);
    }

    public void delete(Long id) {

        Task task = findTask(id);

        repository.delete(task);
    }
}
