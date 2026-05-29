package taskflow_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taskflow_backend.dto.RegisterRequest;
import taskflow_backend.service.AuthService;
import taskflow_backend.dto.LoginRequest;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String registerUser( @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }
    @GetMapping("/test")
    public String test() {
        return "Auth API Working";
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request) {

        return authService.login(request);
    }

}
