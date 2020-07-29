/**
 * 
 */
package com.zemoso.grpc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.grpc.model.Comments;
import com.zemoso.grpc.model.Post;
import com.zemoso.grpc.repository.BlogRepository;
import com.zemoso.grpc.repository.CommentsRepository;

/**
 * @author zadmin
 *
 */
@Service
public class CommentService {

	@Autowired
	CommentsRepository commentsRepository;
	
	public Comments addComments(Comments comments) {
		return commentsRepository.save(comments);
	}
	
	public List<Comments> getAllCommentsByPost(Post post){
		return commentsRepository.findByRefblog(post);
	}
	
}
