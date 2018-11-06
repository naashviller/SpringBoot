package ru.itis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;
import ru.itis.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByLogin(String login) {
        if (userRepository.findUserByLogin(login).isPresent()) {
            return userRepository.findUserByLogin(login).get();
        } else {
            throw new UsernameNotFoundException("User with login " + login + " not found");
        }
    }

    @Override
    public List<User> findListOfUserByLogin(String login) {
        return userRepository.findAllByLogin(login);
    }

    @Override
    public  List<User> findAll(){
       return userRepository.findAll();

    }
}
