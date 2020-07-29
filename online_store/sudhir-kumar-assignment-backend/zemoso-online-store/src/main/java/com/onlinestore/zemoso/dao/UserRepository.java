/**
 * 
 */
package com.onlinestore.zemoso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.zemoso.model.Users;

/**
 * @author sudhirk
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	List<Users> findByUsername(String username);
}
