package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.exceptions.EmailExistsExceptions;
import ru.itis.forms.UserRegistrationForm;
import ru.itis.model.User;
import ru.itis.service.RegistrationService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    private UserRegistrationForm userRegistrationForm;

    @GetMapping("/registration")
    public String register(Model model, Authentication authentication) {
        if (authentication != null) {
            return "redirect:/";
        }

        UserRegistrationForm userRegistrationForm = new UserRegistrationForm();

        model.addAttribute("user", userRegistrationForm);

        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("registrationForm") @Valid UserRegistrationForm userRegistrationForm, BindingResult errors) {
        User registered = new User();

        if (errors.hasErrors()) {
            return "registration";
        } else {
            try {
                registered = registrationService.register(userRegistrationForm);
            } catch (EmailExistsExceptions emailExistsExceptions) {
                emailExistsExceptions.printStackTrace();
            }
        }

        if (registered == null) {
            errors.rejectValue("email", "message.regError");
        }

        return "users";
    }





}
