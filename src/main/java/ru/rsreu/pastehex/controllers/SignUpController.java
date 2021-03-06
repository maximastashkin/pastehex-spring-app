package ru.rsreu.pastehex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rsreu.pastehex.forms.UserSignUpForm;
import ru.rsreu.pastehex.services.signup.UserSignUpService;

@Controller
public class SignUpController {
    private final UserSignUpService userSignUpService;

    @Autowired
    public SignUpController(UserSignUpService userSignUpService) {
        this.userSignUpService = userSignUpService;
    }

    @GetMapping("/signup")
    public String getSignUpPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/";
        }
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(UserSignUpForm userSignUpForm) {
        userSignUpService.signUp(userSignUpForm);
        return "redirect:/signin";
    }
}
