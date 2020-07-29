package com.onlinestore.zemoso.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cart")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;
    @OneToMany(targetEntity = ProductEntity.class)
    private List<ProductEntity> productsOnCart;
    private Double totalPrice;
    private String username;
}
