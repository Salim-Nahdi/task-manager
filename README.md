# Task Manager Pro (Spring Boot + Docker)

A full-stack Task Management application built to demonstrate modern Java development practices, containerization, and cloud deployment.

** [Live Demo Link](https://task-manager-pi8h.onrender.com/)

---

## Key Features
* Full CRUD Functionality: Create, Read, Update, and Delete tasks seamlessly.
* Dynamic Search: Real-time filtering of tasks by title using Spring Data JPA query methods.
* Input Validation: Robust server-side validation to ensure data integrity.
* Responsive UI: Styled with Bootstrap 5 for a clean, mobile-friendly experience.
* Security:Integrated Spring Security for protected routes and data safety.

## Tech Stack
* Backend: Java 17, Spring Boot 3, Spring Data JPA
* Database: H2 (In-Memory for demo purposes)
* Frontend: Thymeleaf, Bootstrap 5
* DevOps: Docker (Multi-stage builds), GitHub, Render (CI/CD)

## How to Run Locally (Docker)
Ensure you have Docker installed, then run:
```bash
docker build -t task-manager .
docker run -p 8080:8080 task-manager
