package com.onlinestore.zemoso.service.cart;

import com.onlinestore.zemoso.dao.CartRepository;
import com.onlinestore.zemoso.dao.ProductRepository;
import com.onlinestore.zemoso.dto.CartDTO;
import com.onlinestore.zemoso.dto.ProductDTO;
import com.onlinestore.zemoso.exception.ProductNotFoundException;
import com.onlinestore.zemoso.model.CartEntity;
import com.onlinestore.zemoso.model.ProductEntity;
import com.onlinestore.zemoso.util.ObjectMapperUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository){
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartDTO addProductToCart(Long productId, String username) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        CartEntity cartEntity = cartRepository.findCartByUsername(username);
        if (productEntity.isSold()){
            return ObjectMapperUtil.map(cartEntity, CartDTO.class);
        }else{

            if (cartEntity == null){
                cartEntity = new CartEntity();
            }
            List<ProductEntity> productsOnCart = new ArrayList<>();
            productsOnCart.add(productEntity);
            if (cartEntity.getProductsOnCart() != null && !cartEntity.getProductsOnCart().isEmpty())
                cartEntity.getProductsOnCart().addAll(productsOnCart);
            else
                cartEntity.setProductsOnCart(productsOnCart);

            productEntity.setSold(true);
            cartEntity.setProductsOnCart(productsOnCart);
            cartEntity.setUsername(username);
            cartEntity.setTotalPrice(productEntity.getPrice());
            cartEntity = cartRepository.save(cartEntity);
            return ObjectMapperUtil.map(cartEntity, CartDTO.class);
        }
    }


    @Override
    public List<ProductDTO> showAllProductsFromCartByUsername(String username) {
        CartEntity cartByUsername = cartRepository.findCartByUsername(username);
        if (cartByUsername == null) return new ArrayList<>(0);
        List<ProductEntity> products = cartByUsername.getProductsOnCart();
        return ObjectMapperUtil.mapAll(products, ProductDTO.class);
    }
}
