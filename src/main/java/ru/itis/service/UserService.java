package ru.itis.service;

import ru.itis.model.User;

import java.util.List;

public interface UserService {

    User findUserByLogin(String login);
     List<User> findListOfUserByLogin(String login);
     List<User> findAll();
}
