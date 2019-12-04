package application.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserLoginRepository extends JpaRepository<UserLogin, UUID> {
    UserLogin findByUsername(String username);
}
