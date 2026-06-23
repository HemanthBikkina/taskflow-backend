package taskflow_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taskflow_backend.dto.UpdateRoleRequest;
import taskflow_backend.dto.UserResponse;
import taskflow_backend.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {

        return adminService.getAllUsers();
    }
    @PutMapping("/users/{id}/role")
    public String UpdateUserRole(
            @PathVariable long id,
            @RequestBody UpdateRoleRequest request
    )
    {
        return adminService.updateUserRole(id, request);
    }


}
