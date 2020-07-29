/**
 * 
 */
package com.zemoso.grpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.grpc.model.Authority;
import com.zemoso.grpc.repository.AuhtorityRepository;

/**
 * @author sudhirk
 *
 */
@Service
public class AuthorityService {
	
	@Autowired
	AuhtorityRepository auhtorityRepository;
	
	public Authority saveAuthority(Authority authority) {
		return auhtorityRepository.save(authority);
	}
}
