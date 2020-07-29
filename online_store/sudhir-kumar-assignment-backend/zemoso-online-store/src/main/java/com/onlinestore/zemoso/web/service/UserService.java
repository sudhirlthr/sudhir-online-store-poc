package com.onlinestore.zemoso.web.service;

import java.util.List;

import com.onlinestore.zemoso.dto.PurchaseDTO;

public interface UserService {
	List<PurchaseDTO> getAllPurchase(String username);
}
