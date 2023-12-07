package com.productservice.productservice.inheritance.mappedclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_men")
public class Mentor extends User{
    private double avgRating;
}
