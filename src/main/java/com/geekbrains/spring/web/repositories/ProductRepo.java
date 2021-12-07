package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    // @Query("select s from Student s where s.name = :name")
    Optional<Product> findById(Long id);

    List<Product> findAll();

    void deleteById(Long aLong);

    Product save(Product product);

    @Query("select p from Product p where p.cost < :max AND p.cost> :min")
    List<Product> findAllBetween(Integer min, Integer max);
}
