package de.salimnahdi.taskmanager.controllers;

import de.salimnahdi.taskmanager.models.Task;
import de.salimnahdi.taskmanager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Tells Spring: "This class handles web requests and returns Data (JSON)"
@RequestMapping("/api/tasks") // All URLs in this class will start with /api/tasks
public class TaskController {

    @Autowired
    private TaskService taskService;

    // GET request to http://localhost:8080/api/tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // POST request to create a new task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
}