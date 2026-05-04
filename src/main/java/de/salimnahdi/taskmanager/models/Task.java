package de.salimnahdi.taskmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;


@Entity
@Data

public class Task {

    @Id // This is the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This makes the ID auto-increment (1, 2, 3...)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;
    private String description;
    private boolean completed;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return createdAt != null ? createdAt.format(formatter) : "";
    }
}
