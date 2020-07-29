/**
 * 
 */
package com.onlinestore.zemoso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.zemoso.model.Authority;

/**
 * @author sudhirk
 *
 */
@Repository
public interface AuhtorityRepository extends JpaRepository<Authority, Long>{

}
