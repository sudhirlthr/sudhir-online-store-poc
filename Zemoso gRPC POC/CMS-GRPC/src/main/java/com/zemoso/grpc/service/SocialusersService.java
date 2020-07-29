/**
 * 
 */
package com.zemoso.grpc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.grpc.model.Socialuser;
import com.zemoso.grpc.repository.SocialusersRepository;

/**
 * @author zadmin
 *
 */
@Service
public class SocialusersService {

	@Autowired
	SocialusersRepository usersRepository;
	
	public Socialuser saveUsers(Socialuser users) {
		return usersRepository.save(users);
	}
	
	public Socialuser getUser(Long userid) {
		return usersRepository.findById(userid).orElse(null);
	}
	
	public Socialuser getUserByEmail(String emailid) {
		List<Socialuser> list = usersRepository.findByEmail(emailid);
		return (list == null || list.size() <1 ) ? null:list.get(0); 
	}
	
	public Socialuser getUserByConfirmationToken(String token) {
		return usersRepository.findByConfirmationToken(token).get(0);
	}
}
