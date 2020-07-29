package com.onlinestore.zemoso.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.onlinestore.zemoso.model.ProductEntity;

import javax.validation.constraints.NotEmpty;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDTO {
    Long cartId;

    @NotEmpty(message = "Products should not empty on cart")
    List<ProductEntity> productsOnCart;
    @NotEmpty(message = "Total price should not be empty")
    Double totalPrice;
    @NotEmpty(message = "Username should not be empty")
    String username;
}
