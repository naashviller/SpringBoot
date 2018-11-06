package ru.itis.service;


import ru.itis.exceptions.EmailExistsExceptions;
import ru.itis.forms.UserRegistrationForm;
import ru.itis.model.User;

public interface RegistrationService {

    User register(UserRegistrationForm userRegistrationForm)throws EmailExistsExceptions;



}
