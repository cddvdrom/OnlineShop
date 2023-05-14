package ru.boronin.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.boronin.onlineshop.entities.Product;
import ru.boronin.onlineshop.services.ProductService;

@Controller
public class AdminController {
    private final ProductService service;
@Autowired
    public AdminController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/admin")
    public String admin (Model model){
        model.addAttribute("products",service.getaAllProducts());
        return "admin";
    }
    @PostMapping("/create")
    public String admin (@ModelAttribute Product product,Model model){
        service.save(product);
        model.addAttribute("products",service.getaAllProducts());
        return "redirect:/admin";
    }
}
