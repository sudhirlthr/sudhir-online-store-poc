/**
 * 
 */
package com.zemoso.grpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.grpc.model.Authority;

/**
 * @author sudhirk
 *
 */
@Repository
public interface AuhtorityRepository extends JpaRepository<Authority, Long>{

}
