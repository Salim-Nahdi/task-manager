package de.salimnahdi.taskmanager.controllers;

import de.salimnahdi.taskmanager.models.Task;
import de.salimnahdi.taskmanager.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // returns HTML views!
public class WebController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /*@GetMapping("/") // The root URL (http://localhost:8080)
    public String index(Model model) {
        // We put the list of tasks into the "Model" so the HTML can see it
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("task", new Task()); // the form has a "blank" task to start with
        return "index"; // This tells Spring to look for a file named index.html
    }*/

    @PostMapping("/add-task")
    public String addTask(@Valid @ModelAttribute Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // If there are errors (like title too short), send them back to the page
            model.addAttribute("tasks", taskService.getAllTasks());
            return "index";
        }
        taskService.createTask(task);
        return "redirect:/";
    }

    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/toggle-task/{id}")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(@RequestParam(value = "search", required = false) String search, Model model) {
        List<Task> tasks = taskService.searchTasks(search);
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        model.addAttribute("searchKeyword", search); // Keep the word in the search bar
        return "index";
    }
}