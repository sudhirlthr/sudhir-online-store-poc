package com.zemoso.grpc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.grpc.model.Comments;
import com.zemoso.grpc.model.Post;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>{
	List<Comments> findByRefblog(Post post);
}
