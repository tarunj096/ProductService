package com.productservice.productservice.services;

import com.productservice.productservice.dto.GenericProductDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();

    GenericProductDto createProduct(GenericProductDto genericProductDto);


    void deleteProductById();
    void updateProductById();
}
