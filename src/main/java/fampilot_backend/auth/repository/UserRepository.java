package fampilot_backend.auth.repository;

import fampilot_backend.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {
boolean existsByEmail(String email);

}
