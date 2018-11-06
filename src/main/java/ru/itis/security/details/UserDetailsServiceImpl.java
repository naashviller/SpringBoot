package ru.itis.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;
import ru.itis.security.enums.Role;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private  final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        System.out.println("THIS EMAIL IS" + login);
        User user = userRepository.findUserByLogin(login).orElseThrow(()
                -> new IllegalArgumentException("User not found by email <" + login + ">"));
        return new UserDetailsImpl(user);
    }
}
