package taskflow_backend.dto;

import lombok.Data;
import taskflow_backend.entity.TaskStatus;

@Data
 public class TaskRequest {

    private String title;

    private String description;

    private TaskStatus status;
}