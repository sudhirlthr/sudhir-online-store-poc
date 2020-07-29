package com.zemoso.grpc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.grpc.model.Socialuser;

@Repository
public interface SocialusersRepository extends JpaRepository<Socialuser, Long>{
	List<Socialuser> findByEmail(String email);
	List<Socialuser> findByConfirmationToken(String confirmationToken);
}
