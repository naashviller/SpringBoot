package ru.itis.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.exceptions.EmailExistsExceptions;
import ru.itis.forms.UserRegistrationForm;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;
import ru.itis.security.enums.Role;
import ru.itis.service.RegistrationService;


@Service
public class RegistrationServiceImpl implements RegistrationService{

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    public User register(UserRegistrationForm userRegistrationForm)throws EmailExistsExceptions {

        User newUser = User.builder()
                .login(userRegistrationForm.getLogin())
                .email(userRegistrationForm.getEmail())
                .password(passwordEncoder.encode(userRegistrationForm.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(newUser);

        return newUser;

    }




}
