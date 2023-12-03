package com.productservice.productservice.services;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.externalClients.fakeStoreClient.FakeStoreClientAdapter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fake")
public class FakeStoreProductService implements ProductService {


   private FakeStoreClientAdapter fakeStoreClientAdapter;
   FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter){
       this.fakeStoreClientAdapter = fakeStoreClientAdapter;
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
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        return convertToGenericProductDto(fakeStoreClientAdapter.getProductById(id));
        //return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
       List<FakeStoreProductDto> fakeStoreProductDtos =  fakeStoreClientAdapter.getAllProducts();
       List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            genericProductDtoList.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtoList;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {

        return convertToGenericProductDto(fakeStoreClientAdapter.createProduct(genericProductDto));
    }


    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertToGenericProductDto(fakeStoreClientAdapter.deleteProductById(id));
    }


    @Override
    public void updateProductById() {

    }
}
