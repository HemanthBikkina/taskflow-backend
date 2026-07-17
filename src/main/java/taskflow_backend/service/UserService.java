package taskflow_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import taskflow_backend.dto.UserResponse;
import taskflow_backend.entity.User;
import taskflow_backend.repository.UserRepository;

public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserResponse getMyProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
