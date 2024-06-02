package com.productservice.productservice.services;

import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<GenericProductDto> searchProducts(String query){
        List<Product> products = productRepository.findAllByTitleContaining(query);
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
            for(Product product:products){
                genericProductDtos.add(product.fromProduct(product));
            }
        return genericProductDtos;
    }
}
