package ru.boronin.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.boronin.onlineshop.DTO.UserDTO;
import ru.boronin.onlineshop.services.ProductService;
import ru.boronin.onlineshop.services.UserService;

@Controller
public class UserController {
    private final UserService userService;

@Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/new")
    public String newUser(Model model){
    model.addAttribute("user",new UserDTO());
    return "registration";
    }

    @PostMapping("/new")
    public String saveUser(@ModelAttribute UserDTO userDTO, Model model){
   userService.save(userDTO);
   return "redirect:/";

    }

}
