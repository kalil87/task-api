package com.example.taskapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Boolean completed;

    public Task(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateCompleted(Boolean completed) {
        if (completed != null) {
            this.completed = completed;
        }
    }
}