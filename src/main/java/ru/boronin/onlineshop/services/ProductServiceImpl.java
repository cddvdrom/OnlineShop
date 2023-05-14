package ru.boronin.onlineshop.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.boronin.onlineshop.entities.Category;
import ru.boronin.onlineshop.entities.Product;
import ru.boronin.onlineshop.repositories.CategoryRepository;
import ru.boronin.onlineshop.repositories.ImagesRepository;
import ru.boronin.onlineshop.repositories.ProductRepository;

import java.util.List;

@Data
@NoArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository repository;
    private CategoryRepository categoryRep;

    private ImagesRepository imagesRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository,CategoryRepository categoryRepository) {

        this.repository = repository;
        this.categoryRep=categoryRepository;
    }

    @Override
    public Page<Product> getProductList(Pageable pageable){
        return repository.findAll(pageable);
    }



    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public List<Product> getaAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List <Category> findAllCategory() {
        return categoryRep.findAll();
    }

    @Override
    public Category findCategoryByName(Long id) {
        return categoryRep.findById(id).orElse(null);
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRep.findById(id).orElse(null);
    }


    @Override
    public Page<Product> findAllProductByCategory(Category category, Pageable pageable) {

       return repository.findProductByCategory(category,pageable);
    }


}
