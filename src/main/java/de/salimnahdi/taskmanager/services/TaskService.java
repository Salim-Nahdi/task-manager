package de.salimnahdi.taskmanager.services;

import de.salimnahdi.taskmanager.models.Task;
import de.salimnahdi.taskmanager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Tells Spring: "This is the business brain of the app"
public class TaskService {

    @Autowired // This "Injects" the Repository so we can use it here
    private TaskRepository taskRepository;

    // A method to get all tasks from the database
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // A method to save a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    // Method to delete a task by its ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Method to flip the status of a task (Completed <-> Pending)
    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        task.setCompleted(!task.isCompleted()); // If true, make false. If false, make true.
        taskRepository.save(task);
    }

    public List<Task> searchTasks(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return taskRepository.findByTitleContainingIgnoreCase(keyword);
        }
        return taskRepository.findAll();
    }
}