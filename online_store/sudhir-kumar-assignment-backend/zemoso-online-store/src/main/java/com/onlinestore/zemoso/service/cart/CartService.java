package com.onlinestore.zemoso.service.cart;

import com.onlinestore.zemoso.dto.CartDTO;
import com.onlinestore.zemoso.dto.ProductDTO;

import java.util.List;

public interface CartService {
    CartDTO addProductToCart(Long productId, String username);
    List<ProductDTO> showAllProductsFromCartByUsername(String username);
}