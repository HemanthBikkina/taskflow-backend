package taskflow_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import taskflow_backend.dto.TaskRequest;
import taskflow_backend.dto.TaskResponse;
import taskflow_backend.entity.Task;
import taskflow_backend.service.TaskService;


import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public String createTask(
            @RequestBody TaskRequest request,
            Authentication authentication
    ) {

        String email = authentication.getName();

        return taskService.createTask(request, email);
    }
    @GetMapping
    public List<TaskResponse> getTasks(Authentication authentication) {
        String email = authentication.getName();
        return taskService.getUserTasks(email);
    }
    @PutMapping("/{id}")
    public TaskResponse updateTask(
            @PathVariable Long id,
            @RequestBody TaskRequest request,
            Authentication authentication
    ) {

        String email = authentication.getName();

        return taskService.updateTask(id, request, email);
    }
    @DeleteMapping("/{id}")
    public String deleteTask(
            @PathVariable Long id,
            Authentication authentication
    ) {

        String email = authentication.getName();

        return taskService.deleteTask(id, email);
    }
}