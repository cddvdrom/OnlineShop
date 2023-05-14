package ru.boronin.onlineshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.boronin.onlineshop.entities.Category;
import ru.boronin.onlineshop.entities.Product;

import java.util.List;

public interface ProductService {
    Page<Product> getProductList(Pageable pageable);


    void save(Product product);
    List<Product> getaAllProducts();
    Product findById(Long id);

    List <Category> findAllCategory();

Category findCategoryByName(Long id);

    Category findCategoryById(Long id);

    Page<Product> findAllProductByCategory(Category category, Pageable pageable);
}
