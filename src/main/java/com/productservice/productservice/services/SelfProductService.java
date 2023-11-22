package com.productservice.productservice.services;

import com.productservice.productservice.dto.GenericProductDto;
import org.springframework.stereotype.Service;

@Service("self")
public class SelfProductService implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void updateProductById() {

    }
}
