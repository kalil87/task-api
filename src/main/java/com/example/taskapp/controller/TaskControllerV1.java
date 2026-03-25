package com.example.taskapp.controller;

import com.example.taskapp.dto.PageResponse;
import com.example.taskapp.dto.TaskCreateDTO;
import com.example.taskapp.dto.TaskResponseDTO;
import com.example.taskapp.mapper.PageMapper;
import com.example.taskapp.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Tasks", description = "Operations related to tasks")
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskControllerV1 {
    private final TaskService service;

    public TaskControllerV1(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<PageResponse<TaskResponseDTO>> getAll(@PageableDefault(size = 5, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(PageMapper.toPageResponse(service.getAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@Valid @RequestBody TaskCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> update(@PathVariable Long id, @Valid @RequestBody TaskCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}