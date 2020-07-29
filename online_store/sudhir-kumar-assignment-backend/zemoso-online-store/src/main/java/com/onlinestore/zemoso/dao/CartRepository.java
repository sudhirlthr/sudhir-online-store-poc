package com.onlinestore.zemoso.dao;

import com.onlinestore.zemoso.model.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findCartByUsername(String username);
}
