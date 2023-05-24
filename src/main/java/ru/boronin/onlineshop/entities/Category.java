package ru.boronin.onlineshop.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.boronin.onlineshop.enums.Categories;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column (name = "name")
    private Categories name;

    @OneToMany(mappedBy = "category")
private List<Product> productList;

}
