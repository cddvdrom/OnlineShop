package ru.boronin.onlineshop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "mark")
    private String mark;
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
private Category category;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "product")
    private List<Image> images = new ArrayList<>();
private Long previewId;
@Column(name = "description",columnDefinition = "text")
    private  String description;
    @Column(name = "price")
    private  double price;

    public Product(String name,String description,double price,Category category) {
        this.name=name;
        this.description=description;
        this.price=price;
        this.category=category;
    }
}
