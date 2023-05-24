package ru.boronin.onlineshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.boronin.onlineshop.util.UserValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserValidator userValidator;

    public AuthController(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @GetMapping("/login")
    public String loginPage(){

        return "/login";
    }
}
