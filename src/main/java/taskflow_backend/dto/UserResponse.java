package taskflow_backend.dto;

import lombok.Getter;
import lombok.Setter;
import taskflow_backend.entity.UserRole;

public class UserResponse {
        @Getter
        @Setter
        private Long id;
        @Getter
        @Setter
        private String name;
        @Getter
        @Setter
        private String email;
        @Getter
        @Setter
        private UserRole role;

    public UserResponse(Long id, String name, String email, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Constructors
        // Getters
        // Setters
    }

