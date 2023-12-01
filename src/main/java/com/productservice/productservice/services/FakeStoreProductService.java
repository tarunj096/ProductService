package com.productservice.productservice.services;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fake")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    String singleProductUrl = "https://fakestoreapi.com/products/{id}";
    String allProductsUrl = "https://fakestoreapi.com/products";
    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
       ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(singleProductUrl,FakeStoreProductDto.class,id);
        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(allProductsUrl,FakeStoreProductDto[].class);
        List<GenericProductDto> result = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtoList = List.of(responseEntity.getBody());
        for (FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtoList){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(allProductsUrl,genericProductDto,FakeStoreProductDto.class);
        return convertToGenericProductDto(responseEntity.getBody());
    }


    @Override
    public void deleteProductById() {

    }

    @Override
    public void updateProductById() {

    }
}
