package com.productservice.productservice.inheritance.mappedclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_ta")
public class Ta extends User {
    private String ta_session;
}
