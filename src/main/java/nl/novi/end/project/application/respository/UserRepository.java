package nl.novi.end.project.application.respository;

import nl.novi.end.project.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
