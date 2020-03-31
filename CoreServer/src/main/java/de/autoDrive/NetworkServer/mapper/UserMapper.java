package de.autoDrive.NetworkServer.mapper;

import de.autoDrive.NetworkServer.entity.User;
import de.autoDrive.NetworkServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    @Autowired
    private UserRepository userRepository;

    public User toEntity(String keycloakUserId, String username) {
        return userRepository.findByKeycloakUserId(keycloakUserId).orElseGet(() -> {
            User user = new User();
            user.setKeycloakUserId(keycloakUserId);
            user.setUsername(username);
            userRepository.save(user);
            return user;
        });
    }
}
