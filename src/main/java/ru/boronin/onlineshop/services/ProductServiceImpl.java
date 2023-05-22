package ru.boronin.onlineshop.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.boronin.onlineshop.entities.Category;
import ru.boronin.onlineshop.entities.Image;
import ru.boronin.onlineshop.entities.Product;
import ru.boronin.onlineshop.repositories.CategoryRepository;
import ru.boronin.onlineshop.repositories.ImagesRepository;
import ru.boronin.onlineshop.repositories.ProductRepository;

import java.io.IOException;
import java.util.List;

@Data
@NoArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;
    private CategoryRepository categoryRep;

    private ImagesRepository imagesRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
                              ImagesRepository imagesRepository) {

        this.productRepository = productRepository;
        this.categoryRep = categoryRepository;
        this.imagesRepository=imagesRepository;
    }

    @Override
    public Page<Product> getProductList(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    @Override

    public void save(Product product, MultipartFile image1, MultipartFile image2, MultipartFile image3
    ) {
        Image img1, img2, img3;
        if (image1.getSize() != 0) {
            img1 = fileToImage(image1);
            img1.setPreview(true);
            img1.setProduct(product);
            product.getImages().add(img1);
        }
        if (image2.getSize() != 0) {
            img2 = fileToImage(image2);
            img2.setProduct(product);
            product.getImages().add(img2);
        }
        if (image3.getSize() != 0) {
            img3 = fileToImage(image3);
            img3.setProduct(product);
            product.getImages().add(img3);
        }

        Product productDb= productRepository.save(product);
        if(!productDb.getImages().isEmpty()){
        product.setPreviewId(productDb.getImages().get(0).getId());}
        productRepository.save(product);

    }

    public void save(Product product){
        productRepository.save(product);}

    private Image fileToImage(MultipartFile file) {
        try {
            return Image.builder().OriginalFilename(file.getOriginalFilename()).
                    name(file.getName()).
                    imageBytes(file.getBytes()).
                    contentType(file.getContentType())
                    .size(file.getSize())
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getaAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAllCategory() {
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

        return productRepository.findProductByCategory(category, pageable);
    }




}
