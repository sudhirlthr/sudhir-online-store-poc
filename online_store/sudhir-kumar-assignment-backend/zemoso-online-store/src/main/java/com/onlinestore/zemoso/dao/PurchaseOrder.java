package com.onlinestore.zemoso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinestore.zemoso.model.Purchase;

public interface PurchaseOrder extends JpaRepository<Purchase, Long>{

}
