package com.productservice.productservice.inheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jp_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class Ta extends User {
    private String ta_session;
}
