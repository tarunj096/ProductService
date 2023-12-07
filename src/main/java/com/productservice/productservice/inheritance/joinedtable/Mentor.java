package com.productservice.productservice.inheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jp_men")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
    private double avgRating;
}
