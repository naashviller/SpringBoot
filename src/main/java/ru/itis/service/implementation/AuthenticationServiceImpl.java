package ru.itis.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.service.AuthenticationService;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl currentUserDetails = (UserDetailsImpl) authentication.getPrincipal();
        User currentUser = currentUserDetails.getUser();
        System.out.println("OUR CURRENT USER IS " + currentUser);

        return userRepository.findUserByLogin(currentUser.getLogin());
    }
}
