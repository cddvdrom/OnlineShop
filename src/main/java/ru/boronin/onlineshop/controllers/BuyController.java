package ru.boronin.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ru.boronin.onlineshop.entities.Bucket;
import ru.boronin.onlineshop.entities.BucketDetail;
import ru.boronin.onlineshop.services.BuyService;
import ru.boronin.onlineshop.services.ProductService;

@Controller
public class BuyController {
    private final ProductService productService;
    private final BuyService buyService;
@Autowired
    public BuyController(ProductService productService, BuyService buyService) {
        this.productService = productService;
        this.buyService = buyService;
    }

    @GetMapping ("/addShoppingCart/{id}")
    public String addShoppingCart(@PathVariable Long id,
                                    @RequestParam(value = "quantity", defaultValue = "1") int quantity, Model model) {
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("quantity",quantity);
        model.addAttribute("bucketDetails",new BucketDetail(productService.findById(id),quantity));

        return "shopingCart";

    }
    @PostMapping("/addBasket")
public String addBucket(@ModelAttribute BucketDetail bucketDetail, Model model){
    Bucket bucket=new Bucket();
    bucket.getBucketDetails().add(bucketDetail);
    return "redirect:/";
}
}