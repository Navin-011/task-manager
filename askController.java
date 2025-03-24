package com.example.taskmanager;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Allow frontend requests
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getTasks() { return service.getTasks(); }

    @PostMapping
    public Task addTask(@RequestBody Task task) { return service.addTask(task); }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) { service.deleteTask(id); }
}
