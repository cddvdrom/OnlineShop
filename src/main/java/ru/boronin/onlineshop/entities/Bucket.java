package ru.boronin.onlineshop.entities;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Bucket {
    private Long id;
    private Map<Product,Integer> productList;

    public Bucket(){
        this.productList=new HashMap<>();
    }
}
