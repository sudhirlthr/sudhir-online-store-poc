package com.onlinestore.zemoso.web.service;

import java.util.List;

import com.onlinestore.zemoso.dto.PurchaseDTO;

public interface PurchaseService {
	
	PurchaseDTO getPurchaseByPurchaseId(Long purchase_id);
	List<PurchaseDTO> getPurchaseByUsername(String email);
}
