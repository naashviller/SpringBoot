package ru.itis.service;


import org.springframework.security.core.Authentication;
import ru.itis.model.User;

import java.util.Optional;

public interface AuthenticationService {

    Optional<User> getUserByAuthentication(Authentication authentication);

}
