package com.productservice.productservice.externalClients.fakeStoreClient;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClientAdapter {

    private RestTemplateBuilder restTemplateBuilder;

    private String fakeStoreUrl;

    private String pathForProducts;
    String singleProductUrl;
    String allProductsUrl = "https://fakestoreapi.com/products";
    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreUrl, @Value("${fakestore.api.path.products}") String pathForProducts){
        this.singleProductUrl = fakeStoreUrl+pathForProducts+"/{id}";
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(singleProductUrl,FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto==null){
            throw new ProductNotFoundException("Product with id :"+ id+ " doesn't exist");
        }
        return responseEntity.getBody();
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(allProductsUrl,FakeStoreProductDto[].class);
        return List.of(responseEntity.getBody());
    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(allProductsUrl,genericProductDto,FakeStoreProductDto.class);
        return responseEntity.getBody();
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.execute(singleProductUrl, HttpMethod.DELETE,requestCallback,responseExtractor,id);
        return responseEntity.getBody();
    }


    public void updateProductById() {

    }
}
