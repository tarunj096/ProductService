package com.productservice.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Component
public class TokenValidator {

    private RestTemplateBuilder restTemplateBuilder;
    TokenValidator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    /**
     * This method should call the UserService to validate the token
     * if the token is valid then return the object else return empty
     * @param token
     * @return
     */
    public Optional<JWTObject> validateToken(String token){
        RestTemplate restTemplate = restTemplateBuilder.build();

        //Http call to validate token method in user service

        return null;
    }
}
