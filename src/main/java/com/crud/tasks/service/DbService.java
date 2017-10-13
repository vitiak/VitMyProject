package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTask(Integer id) {
        Optional<Task> optionalTask = repository.findById(id);
        return optionalTask;
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }

    public void deleteTask(Integer id) {
        repository.deleteById(id);
    }
}
