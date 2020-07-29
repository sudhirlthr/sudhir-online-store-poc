package com.onlinestore.zemoso.dao;

import com.onlinestore.zemoso.model.PurchaseOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderEntity, Long>{
	List<PurchaseOrderEntity> findByUser(String user);
}
