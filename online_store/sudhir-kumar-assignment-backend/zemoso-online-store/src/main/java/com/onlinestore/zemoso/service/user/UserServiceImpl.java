package com.onlinestore.zemoso.service.user;

import java.util.ArrayList;
import java.util.List;

import com.onlinestore.zemoso.exception.UserNotSavedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.zemoso.dao.PurchaseOrderRepository;
import com.onlinestore.zemoso.dao.UserRepository;
import com.onlinestore.zemoso.dto.PurchaseOrderDTO;
import com.onlinestore.zemoso.exception.PurchaseOrderNotFoundException;
import com.onlinestore.zemoso.exception.UserNotFoundException;
import com.onlinestore.zemoso.model.PurchaseOrderEntity;
import com.onlinestore.zemoso.model.Users;
import com.onlinestore.zemoso.util.ObjectMapperUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	PurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Users saveuser(Users users) {
		try {
			if( users == null) throw new UserNotSavedException();
			users = userRepository.save(users);
		}catch (UserNotSavedException exception){
			exception.printStackTrace();
		}
		return users;
	}

	@Override
	public List<PurchaseOrderDTO> getAllPurchaseByUsername(String username) {
		List<PurchaseOrderDTO> puchaseOrdersDTO = new ArrayList<>();
		try {
			List<Users> users = userRepository.findByUsername(username);
			if(users == null) throw new UserNotFoundException(username);
			List<PurchaseOrderEntity> purchaseOrderEntities = purchaseOrderRepository.findByUser(users.get(0));
			if(purchaseOrderEntities == null) throw new PurchaseOrderNotFoundException();
			puchaseOrdersDTO = ObjectMapperUtil.mapAll(purchaseOrderEntities, PurchaseOrderDTO.class);
		} catch (UserNotFoundException | PurchaseOrderNotFoundException exception) {
			exception.printStackTrace();
		}
		return puchaseOrdersDTO;
	}

}
