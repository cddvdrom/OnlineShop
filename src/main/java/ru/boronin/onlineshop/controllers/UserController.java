package ru.boronin.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.boronin.onlineshop.DTO.UserDTO;
import ru.boronin.onlineshop.services.UserService;
import ru.boronin.onlineshop.util.UserValidator;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;



@Autowired
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;

    this.userValidator = userValidator;
}

    @GetMapping("/new")
    public String newUser(Model model){
    model.addAttribute("user",new UserDTO());

    return "registration";
    }

    @PostMapping("/new")
    public String saveUser(@ModelAttribute @Valid UserDTO userDTO, Model model, BindingResult bindingResult){
//userValidator.validate(userDTO,bindingResult);
   userService.save(userDTO);
   return "redirect:/";

    }

}
