package taskflow_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskflow_backend.dto.RegisterRequest;
import taskflow_backend.entity.User;
import taskflow_backend.entity.UserRole;
import taskflow_backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import taskflow_backend.dto.LoginRequest;
import taskflow_backend.security.JwtService;
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(UserRole.EMPLOYEE);

        userRepository.save(user);

        return "User Registered Successfully";
    }
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!passwordMatches) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return token;
    }


    @Autowired
    private JwtService jwtService;
}