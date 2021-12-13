package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.web.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Получение
    @GetMapping
    public Page<ProductDto> getAllProducts(
        @RequestParam(name = "p", defaultValue = "1") Integer page,
        @RequestParam(name = "min_cost", required = false) Integer minCost,
        @RequestParam(name = "max_cost", required = false) Integer maxCost,
        @RequestParam(name = "name_part", required = false) String namePart
    ) {
            if (page < 1) {
                page = 1;
            }
            return productService.find(minCost, maxCost, namePart, page).map(
                    p -> new ProductDto(p)
            );
    }

    //Получение
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    //Добавление
    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        product.setId(null);
        productService.saveProduct(product);
    }

    //Модификация
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    //Удаление
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
