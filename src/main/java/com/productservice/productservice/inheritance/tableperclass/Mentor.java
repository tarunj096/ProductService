package com.productservice.productservice.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_men")
public class Mentor extends User {
    private double avgRating;
}
