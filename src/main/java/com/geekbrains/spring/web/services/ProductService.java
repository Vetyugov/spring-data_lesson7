package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.repositories.ProductRepo;
import com.geekbrains.spring.web.repositories.specifications.ProductsSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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

    public Page<Product> find(Integer minCost, Integer maxCost, String partName, Integer page) {
        Specification<Product> spec = Specification.where(null);
        if (minCost != null) {
            spec = spec.and(ProductsSpecifications.costGreaterOrEqualsThan(minCost));
        }
        if (maxCost != null) {
            spec = spec.and(ProductsSpecifications.costLessThanOrEqualsThan(maxCost));
        }
        if (partName != null) {
            spec = spec.and(ProductsSpecifications.nameLike(partName));
        }

        return productRepo.findAll(spec, PageRequest.of(page - 1, 5));
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

}
