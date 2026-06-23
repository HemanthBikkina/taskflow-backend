package taskflow_backend.dto;

import taskflow_backend.entity.UserRole;

public class UpdateRoleRequest {

    private UserRole role;

    public UpdateRoleRequest() {
    }

    public UpdateRoleRequest(UserRole role) {
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}