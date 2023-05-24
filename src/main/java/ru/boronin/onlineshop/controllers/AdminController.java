package ru.boronin.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.boronin.onlineshop.entities.Category;
import ru.boronin.onlineshop.entities.Product;
import ru.boronin.onlineshop.services.ProductService;
import ru.boronin.onlineshop.services.UserService;

import java.math.BigDecimal;
import java.util.List;


@Controller
public class AdminController {
    private final UserService userService;
    private final ProductService service;
@Autowired
    public AdminController(UserService userService, ProductService service) {
    this.userService = userService;
    this.service = service;
    }

    @GetMapping("/admin")
    public String admin (Model model){
    List<Category> categoryList=service.findAllCategory();
    model.addAttribute("categories",categoryList);
        model.addAttribute("products",service.getaAllProducts());
        model.addAttribute("users",userService.getaAllUsers());
        return "admin";
    }
    @PostMapping("/create")
    public String admin(
                         @RequestParam ("file1")MultipartFile file1,
                         @RequestParam ("file2")MultipartFile file2,
                         @RequestParam ("file3")MultipartFile file3
            , @ModelAttribute Product product,Model model){

        service.save(product,file1,file2,file3);
        model.addAttribute("products",service.getaAllProducts());

        return "redirect:/admin";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct (@PathVariable Long id){
    service.deleteProduct(id);
    return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editProduct (@PathVariable Long id, @RequestParam("name") String name,
                               @RequestParam("mark") String mark,
                               @RequestParam("price")BigDecimal price){
        Product product=service.findById(id);
        product.setMark(mark);
        product.setName(name);
        product.setPrice(price);
        service.save(product);
        return "redirect:/admin";
    }
}
