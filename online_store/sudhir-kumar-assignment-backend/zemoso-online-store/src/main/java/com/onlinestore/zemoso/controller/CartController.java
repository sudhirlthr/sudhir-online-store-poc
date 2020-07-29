package com.onlinestore.zemoso.controller;

import com.onlinestore.zemoso.dto.ProductDTO;
import com.onlinestore.zemoso.service.cart.CartService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/addProduct/{productId}")
    public void addProductTocart(@PathVariable Long productId, Authentication authentication){
        cartService.addProductToCart(productId, authentication.getName());
    }

    @GetMapping("/getProducts")
    public List<ProductDTO> getAllProducts(Authentication authentication){
        return cartService.showAllProductsFromCartByUsername(authentication.getName());
    }
}
