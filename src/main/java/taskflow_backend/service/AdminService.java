package taskflow_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskflow_backend.dto.UpdateRoleRequest;
import taskflow_backend.dto.UserResponse;
import taskflow_backend.entity.User;
import taskflow_backend.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    public List<UserResponse> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole()
                ))
                .collect(Collectors.toList());
    }
    public String updateUserRole(
            Long userId,
            UpdateRoleRequest request
    ) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        user.setRole(request.getRole());

        userRepository.save(user);

        return "User Role Updated Successfully";
    }
}
