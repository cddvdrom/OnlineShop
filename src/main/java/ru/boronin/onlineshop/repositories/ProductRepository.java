package ru.boronin.onlineshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.boronin.onlineshop.entities.Category;
import ru.boronin.onlineshop.entities.Product;

@Repository

public interface ProductRepository extends JpaRepository <Product,Long> {

    Page<Product> findProductByCategory(Category category, Pageable pageable);

}
