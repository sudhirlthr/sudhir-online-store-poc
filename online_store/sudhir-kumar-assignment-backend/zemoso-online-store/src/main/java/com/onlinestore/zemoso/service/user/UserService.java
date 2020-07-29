package com.onlinestore.zemoso.service.user;

import java.util.List;

import com.onlinestore.zemoso.dto.PurchaseOrderDTO;
import com.onlinestore.zemoso.model.Users;

public interface UserService {
	Users saveuser(Users users);
	List<PurchaseOrderDTO> getAllPurchaseByUsername(String username);
}
