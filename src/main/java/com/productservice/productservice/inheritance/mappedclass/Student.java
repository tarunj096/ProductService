package com.productservice.productservice.inheritance.mappedclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_stud")
public class Student extends User{
    private double psp;
}
