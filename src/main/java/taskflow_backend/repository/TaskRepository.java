package taskflow_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskflow_backend.entity.Task;
import taskflow_backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);;
    Optional<Task> findByIdAndUser(Long id, User user);
}