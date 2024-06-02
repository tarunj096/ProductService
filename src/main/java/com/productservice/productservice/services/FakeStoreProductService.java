package com.productservice.productservice.services;

import com.productservice.productservice.dto.FakeStoreProductDto;
import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.externalClients.fakeStoreClient.FakeStoreClientAdapter;
import com.productservice.productservice.security.JWTObject;
import com.productservice.productservice.security.TokenValidator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("fake")
public class FakeStoreProductService implements ProductService {


   private FakeStoreClientAdapter fakeStoreClientAdapter;
   private TokenValidator tokenValidator;
    private RedisTemplate<String,FakeStoreProductDto> redisTemplate;
   FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter,TokenValidator tokenValidator,RedisTemplate redisTemplate){
       this.fakeStoreClientAdapter = fakeStoreClientAdapter;
       this.tokenValidator = tokenValidator;
       this.redisTemplate = redisTemplate;
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
    public GenericProductDto getProductById(String authToken,Long id) throws ProductNotFoundException {
        System.out.println(authToken);
        Optional<JWTObject> jwtObjectOptional = tokenValidator.validateToken(authToken);
//        if (jwtObjectOptional.isEmpty()){
//            //Invalid Token
//        }
//        JWTObject jwtObject = jwtObjectOptional.get();
//        Long userId = jwtObject.getUserId();
        FakeStoreProductDto fakeStoreProductDto = (FakeStoreProductDto) redisTemplate.opsForHash().get("product",id);
        if(fakeStoreProductDto!=null){
            return convertToGenericProductDto(fakeStoreProductDto);
        }
        fakeStoreProductDto = fakeStoreClientAdapter.getProductById(id);
        redisTemplate.opsForHash().put("product",id,fakeStoreProductDto);
        return convertToGenericProductDto(fakeStoreProductDto);
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
