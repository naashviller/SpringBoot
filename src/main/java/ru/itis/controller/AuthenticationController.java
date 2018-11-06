package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.model.User;
import ru.itis.security.enums.Role;
import ru.itis.service.AuthenticationService;
import ru.itis.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @GetMapping("/signIn")
    public String login(Authentication authentication) {
        if (authentication != null) {

            return "redirect:/";
        }
        else {
            System.out.println("AUTH IS NULL");
        }

        return "signIn";
    }
    @GetMapping("/")
    public String root(Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication).orElseGet(null);
            System.out.println("МЫ ВОШЛИ С " + user.getEmail());
            return "redirect:/users";
        }
        else return "signIn";

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Authentication authentication) {
        if (authentication != null) {
            request.getSession().invalidate();
        }

        return "redirect:/signIn";
    }

}
