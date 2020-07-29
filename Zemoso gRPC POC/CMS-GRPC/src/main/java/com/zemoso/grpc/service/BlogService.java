/**
 * 
 */
package com.zemoso.grpc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.grpc.model.Post;
import com.zemoso.grpc.repository.BlogRepository;

/**
 * @author zadmin
 *
 */
@Service
public class BlogService {

	@Autowired
	BlogRepository blogRepository;
	
	public List<Post> getAllBlogs(){
		return blogRepository.findAll();
	}
	
	public Post getPostByid(Long postid) {
		return blogRepository.getOne(postid);
	}
	
	public Post createBlog(Post blog) {
		return blogRepository.save(blog);
	}
	
	public Post modifyBlog(Post blog) {
		return blogRepository.save(blog);
	}
	
	public void deteteBlog(Long blogid) {
		blogRepository.deleteById(blogid);
	}
}
