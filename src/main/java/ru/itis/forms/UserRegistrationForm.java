package ru.itis.forms;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationForm {

    @NotNull
    @Size(min = 5, max = 50)
    private String login;

    @NotNull
    @Size(min = 6)
    private String password;

    private boolean checkEmail;

    @Valid
    private String email;


}
