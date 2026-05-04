package de.salimnahdi.taskmanager.services;

import de.salimnahdi.taskmanager.models.Task;
import de.salimnahdi.taskmanager.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Tells Spring: "Manage this class and run it automatically"
public class DataInitializer implements CommandLineRunner {

    private final TaskRepository taskRepository;

    // Constructor injection (The most professional way to do @Autowired)
    public DataInitializer(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Task 1
        Task task1 = new Task();
        task1.setTitle("Build the Backend");
        task1.setDescription("Set up Spring Boot, Security, and H2");
        task1.setCompleted(true);

        // Create Task 2
        Task task2 = new Task();
        task2.setTitle("Learn Java Persistence");
        task2.setDescription("Understand how @Entity and Repositories work");
        task2.setCompleted(false);

        // Save them to the database
        taskRepository.save(task1);
        taskRepository.save(task2);

        System.out.println("Sample tasks have been loaded into the database!");
    }
}