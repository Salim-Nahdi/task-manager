package de.salimnahdi.taskmanager.repositories;

import de.salimnahdi.taskmanager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Tells Spring this is our Database Messenger
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitleContainingIgnoreCase(String title);
    // JpaRepository already has save(), findAll(), delete() built-in.
}