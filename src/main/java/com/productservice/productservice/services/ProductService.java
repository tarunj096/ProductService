package com.productservice.productservice.services;

import com.productservice.productservice.dto.GenericProductDto;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();

    void createProduct();

    void deleteProductById();
    void updateProductById();
}
