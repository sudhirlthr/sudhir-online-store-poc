/**
 * 
 */
package com.zemoso.grpc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.grpc.model.Users;
import com.zemoso.grpc.repository.UserRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class UsersService {
	
	@Autowired
	UserRepository userRepository;
	
	public Users saveUser(Users users) {
		return userRepository.save(users);
	}	

	public Users findUserByUserName(String username) {
		List<Users> userList = userRepository.findByUsername(username);
		return userList == null ? null:userList.get(0);
	}
}
