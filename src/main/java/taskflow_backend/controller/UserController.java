package taskflow_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taskflow_backend.dto.UserResponse;
import taskflow_backend.service.UserService;
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/me")
    public UserResponse getMyProfile(
            Authentication authentication
    ) {

        String email = authentication.getName();

        return userService.getMyProfile(email);
    }
}
