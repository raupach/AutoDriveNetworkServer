package de.autoDrive.NetworkServer.repository;

import de.autoDrive.NetworkServer.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByKeycloakUserId(String s);
}
