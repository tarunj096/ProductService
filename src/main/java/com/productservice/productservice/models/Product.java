package com.productservice.productservice.models;

import com.productservice.productservice.dto.GenericProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{

    private String title;
    private String description;

    private String image;
    @ManyToOne(optional = false)
    private Category category;

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Price price;

    public GenericProductDto fromProduct(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        //genericProductDto.setId(product.getId());
        genericProductDto.setTitle(product.getTitle());
        // genericProductDto.setPrice(product.getPrice());
        //genericProductDto.setCategory(product.getCategory());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setImage(product.getImage());
        return genericProductDto;
    }

}
