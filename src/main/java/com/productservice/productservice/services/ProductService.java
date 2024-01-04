package com.productservice.productservice.services;

import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(String authToken, Long id) throws ProductNotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto createProduct(GenericProductDto genericProductDto);


    GenericProductDto deleteProductById(Long id);
    void updateProductById();
}
