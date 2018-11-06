package ru.itis.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;

import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {
    private UserRepository usersRepository;

    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthProvider(UserRepository usersRepository, UserDetailsService userDetailsService) {
        this.usersRepository = usersRepository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();

        System.out.println("THIS EMAIL IS FROM AUTHENTICATION " + login);
        String password = authentication.getCredentials()
                .toString();
        System.out.println("THIS PASSWORD IS FROM AUTHENTICATION " + password);

        User user = usersRepository.findUserByEmail(login);
        UserDetails details = null;
        Collection<? extends GrantedAuthority> authorities = null;
        if (passwordEncoder.matches(password, user.getPassword())) {
             details = userDetailsService.loadUserByUsername(login);
             authorities = details.getAuthorities();

            System.out.println("PREPARING TO RETURN AUTH PARAMETERS");
        }
        return new UsernamePasswordAuthenticationToken(details, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
