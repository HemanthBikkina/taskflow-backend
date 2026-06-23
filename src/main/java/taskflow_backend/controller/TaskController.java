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
    public List<TaskResponse> getTasks(Authentication authentication, @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "5") int size,@RequestParam(defaultValue = "id") String sort) {
        String email = authentication.getName();
        return taskService.getUserTasks(email, page, size,sort);
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
    @GetMapping("/role")
    public String getRole(Authentication authentication) {

        return authentication.getAuthorities().toString();
    }
    @GetMapping("/admin")
    public String asminOnly()
    {
        return "Welcome admin";
    }
}