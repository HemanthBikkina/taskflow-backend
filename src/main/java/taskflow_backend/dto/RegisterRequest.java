package taskflow_backend.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class RegisterRequest {
@NotBlank(message = "NAme is required")
    private String name;
@Email(message ="Inavalid email Format")
@NotBlank(message="Email iss required")
    private String email;
@Size(min=6,message ="password must be at least 6 characters")

    private String password;
}