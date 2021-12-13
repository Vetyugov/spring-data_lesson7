package com.geekbrains.spring.web.dto;

import com.geekbrains.spring.web.entities.Product;

public class ProductDto {
    private Long id;
    private String name;
    private Integer cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer score) {
        this.cost = cost;
    }

    public ProductDto(Product product) {
        this.name = product.getName();
        this.id = product.getId();
        this.cost = product.getCost();
    }

    public ProductDto() {
    }
}
