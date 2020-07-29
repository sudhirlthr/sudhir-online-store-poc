/**
 * 
 */
package com.zemoso.grpc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.grpc.model.Users;

/**
 * @author sudhirk
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	List<Users> findByUsername(String username);
}
