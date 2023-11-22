package com.productservice.productservice.services;

import com.productservice.productservice.dto.GenericProductDto;

public interface ProductService {
    GenericProductDto getProductById(Long id);

    void getAllProducts();

    void createProduct();

    void deleteProductById();
    void updateProductById();
}
