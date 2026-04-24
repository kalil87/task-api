package com.example.taskapp.service;

import com.example.taskapp.dto.TaskCreateDTO;
import com.example.taskapp.dto.TaskResponseDTO;
import com.example.taskapp.exception.TaskNotFoundException;
import com.example.taskapp.mapper.TaskMapper;
import com.example.taskapp.model.Task;
import com.example.taskapp.repository.TaskRepository;
import com.example.taskapp.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskService(TaskRepository repository, TaskMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    private Task findTask(Long id) {
        log.info("Searching task with id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Task not found with id: {}", id);
                    return new TaskNotFoundException(Message.TASK_NOT_FOUND);
                });
    }

    public Page<TaskResponseDTO> getAll(Pageable pageable){
        log.info("Fetching all tasks with pagination: {}", pageable);
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public TaskResponseDTO getById(Long id) {
        log.info("Getting task by id: {}", id);
        Task task = findTask(id);
        log.info("Task found with id: {}", id);
        return mapper.toDTO(task);
    }

    public TaskResponseDTO create(TaskCreateDTO dto) {
        log.info("Creating task with title: {}", dto.title());
        Task task = mapper.toEntity(dto);
        Task saved = repository.save(task);
        log.info("Task created with id: {}", saved.getId());
        return mapper.toDTO(saved);
    }

    public TaskResponseDTO update(Long id, TaskCreateDTO dto) {
        log.info("Updating task with id: {}", id);
        Task existing = findTask(id);
        existing.updateTitle(dto.title());
        existing.updateCompleted(dto.completed());
        Task updated = repository.save(existing);
        log.info("Task updated with id: {}", updated.getId());
        return mapper.toDTO(updated);
    }

    public void delete(Long id) {
        log.info("Deleting task with id: {}", id);
        Task task = findTask(id);
        repository.delete(task);
        log.info("Task deleted with id: {}", id);
    }
}