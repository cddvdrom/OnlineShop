package ru.boronin.onlineshop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("/orders")
    public ResponseEntity<?> getOrders() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
