package com.productservice.productservice.inheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jp_stud")
@PrimaryKeyJoinColumn(name="user_id")
public class Student extends User {
    private double psp;
}
