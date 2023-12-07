package com.productservice.productservice.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tb_ta")
public class Ta extends User {
    private String ta_session;
}
