package ru.itis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.model.User;
import ru.itis.service.UserService;

import java.util.List;


@Controller
public class UsersController {

    private UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service= service;
    }

    @GetMapping("/users")
    public String getUsers(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("users",service.findAll());
        return "users";
    }


}
