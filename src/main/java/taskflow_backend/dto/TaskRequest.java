package taskflow_backend.dto;

import lombok.Data;

@Data
 public class TaskRequest {

    private String title;

    private String description;

    private String status;
}