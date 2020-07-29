package com.onlinestore.zemoso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinestore.zemoso.model.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
