package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllStudents() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/new_product")
    public void save(@RequestParam String name, @RequestParam Integer cost) {
        productService.saveProduct(name, cost);
    }

    @GetMapping("/products/cost_between")
    public List<Product> getAllStudentsBetween(@RequestParam(defaultValue = "-1") Integer min, @RequestParam(defaultValue = "-1") Integer max) {
        if (min == -1 && max == -1) {
            return productService.findAll();
        } else if (min == -1) {
            return productService.findAllLowCost(max);
        } else if (max == -1) {
            return productService.findAllHighCost(min);
        }
        return productService.findAllBetween(min, max);
    }


}