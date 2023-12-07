package com.productservice.productservice.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tb_stud")
public class Student extends User {
    private double psp;
}
