package com.productservice.productservice.controller;

import com.productservice.productservice.dto.GenericProductDto;
import com.productservice.productservice.dto.SearchRequestDto;
import com.productservice.productservice.services.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public List<GenericProductDto> searchProducts(@RequestBody SearchRequestDto requestDto){
        return searchService.searchProducts(requestDto.getQuery());
    }
}
