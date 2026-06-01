package taskflow_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskflow_backend.dto.TaskResponse;
import java.util.stream.Collectors;
import taskflow_backend.dto.TaskRequest;
import taskflow_backend.entity.Task;
import taskflow_backend.entity.User;
import taskflow_backend.repository.TaskRepository;
import taskflow_backend.repository.UserRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public String createTask(TaskRequest request, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());

        task.setUser(user);

        taskRepository.save(task);

        return "Task Created Successfully";
    }
    public List<TaskResponse> getUserTasks(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        List<Task> tasks=taskRepository.findByUser(user);
        return tasks.stream()
                .map(task -> new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus(),
                        task.getCreatedAt(),
                        task.getUpdatedAt()
                ))
                .collect(Collectors.toList());
    }
    public TaskResponse updateTask(
            Long taskId,
            TaskRequest request,
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Task task = taskRepository.findByIdAndUser(taskId, user)
                .orElseThrow(() -> new RuntimeException("Task Not Found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());

        Task updatedTask = taskRepository.save(task);

        return new TaskResponse(
                updatedTask.getId(),
                updatedTask.getTitle(),
                updatedTask.getDescription(),
                updatedTask.getStatus(),
                updatedTask.getCreatedAt(),
                updatedTask.getUpdatedAt()
        );
    }
    public String deleteTask(Long taskId, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Task task = taskRepository.findByIdAndUser(taskId, user)
                .orElseThrow(() -> new RuntimeException("Task Not Found"));

        taskRepository.delete(task);

        return "Task Deleted Successfully";
    }
}