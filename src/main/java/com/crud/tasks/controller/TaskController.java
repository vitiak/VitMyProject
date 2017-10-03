package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

    public TaskDto getTask(String taskId) {
        return new TaskDto((long)1, "test title", "test_content");
    }

    public void deleteTask(String taskId) {

    }

    public void createTask(String taskId) {

    }

    public TaskDto updateTask(TaskDto task) {
        return new TaskDto((long)1, "Edited test title", "Test content");
    }

}
