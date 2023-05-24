package ru.boronin.onlineshop.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "mark")
    private String mark;
    //@ManyToMany
    //@JoinTable(name = "products_categories",
    //joinColumns = @JoinColumn(name = "product_id"),
    //inverseJoinColumns = @JoinColumn(name = "category_id"))
    //private List <Category> categoryList;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    private Long previewId;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price")
    private BigDecimal price;


}
