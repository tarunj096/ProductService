package com.productservice.productservice.repositories;

import com.productservice.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    List<Product> findAll();

    List<Product> findAllByTitle(String title);

    List<Product> findAllByTitleContaining(String title);
    List<Product> findAllByPrice_ValueGreaterThan(Integer x);

    //@Query()
    List<Product> findAllByPrice_ValueBetween(Integer x,Integer y);
}
