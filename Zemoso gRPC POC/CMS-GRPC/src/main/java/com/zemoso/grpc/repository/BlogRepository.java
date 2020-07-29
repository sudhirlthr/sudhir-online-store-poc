/**
 * 
 */
package com.zemoso.grpc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.grpc.model.Post;

/**
 * @author zadmin
 *
 */
@Transactional
@Repository
public interface BlogRepository extends JpaRepository<Post, Long>{

}
