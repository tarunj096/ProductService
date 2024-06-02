package com.productservice.productservice.controller;

import com.productservice.productservice.dto.ExceptionDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;


    @Autowired
    ProductController(@Qualifier("fake") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken, @PathVariable("id") Long id) throws ProductNotFoundException {

        return productService.getProductById(authToken,id);
    }

    @GetMapping("/")
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }
    @PostMapping("/")
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

    @PatchMapping("/{id}")
    public void updateProductById(@PathVariable("id") Long id){

    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        System.out.println("Got product not found exception");
//        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }

}
