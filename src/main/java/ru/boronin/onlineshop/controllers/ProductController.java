package ru.boronin.onlineshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.boronin.onlineshop.entities.Category;
import ru.boronin.onlineshop.entities.Image;
import ru.boronin.onlineshop.entities.Product;
import ru.boronin.onlineshop.services.ProductService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    //   @GetMapping("/")
    //   public String allProducts(Model model){
    //       model.addAttribute("products",service.getaAllProducts());
    //       model.addAttribute("categories",service.findAllCategory());
    //       return "all";
    //  }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product=service.findById(id);
        List<Image> imageList=product.getImages();
        model.addAttribute("images",imageList);
        model.addAttribute("product", product);
        return "productInfo";
    }

    @GetMapping("/")
    public String productPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "6") Integer size, Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> pages = service.getProductList(pageable);
        model.addAttribute("products", pages.getContent());
        model.addAttribute("categories", service.findAllCategory());
        return "all";
    }

    @GetMapping("/category/{id}")
    public String productPagebyCategory(@PathVariable Long id,@RequestParam(value = "page", defaultValue = "0") Integer page,
                                        @RequestParam(value = "size", defaultValue = "6") Integer size, Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Category category=service.findCategoryById(id);
        Page<Product> pages=service.findAllProductByCategory(category,pageable);
       model.addAttribute("products", pages.getContent());
        model.addAttribute("categories", service.findAllCategory());
        return "all";
    }
}
