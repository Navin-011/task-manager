package com.example.taskmanager;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getTasks() { return repository.findAll(); }
    public Task addTask(Task task) { return repository.save(task); }
    public void deleteTask(Long id) { repository.deleteById(id); }
}
