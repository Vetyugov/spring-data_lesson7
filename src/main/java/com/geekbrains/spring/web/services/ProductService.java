package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.repositories.ProductRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    /**
     * @return получение товара по id
     */
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    /**
     * @return получение всех товаров
     */
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    /**
     * @return удаление товара по id
     */
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> findAllBetween(Integer min, Integer max) {
        return productRepo.findAllBetween(min, max);
    }
}
