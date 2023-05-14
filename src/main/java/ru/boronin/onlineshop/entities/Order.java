package ru.boronin.onlineshop.entities;

import jakarta.persistence.Table;

import java.util.Date;
@Table(name = "orders")
public class Order {
    private Long id;
    private Bucket bucket;
    private Client client;
    private Date date;


}
