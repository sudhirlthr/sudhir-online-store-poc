package com.onlinestore.zemoso.service.purchase;

import com.onlinestore.zemoso.dto.PurchaseOrderDTO;

import java.util.List;

public interface PurchaseOrderService {

	PurchaseOrderDTO getPurchaseByPurchaseId(Long purchaseId);
	List<PurchaseOrderDTO> getPurchaseByUsername(String email);
	PurchaseOrderDTO createPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO);
}
