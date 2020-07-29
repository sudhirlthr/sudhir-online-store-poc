package com.zemoso.grpc.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zemoso.grpc.model.Post;
import com.zemoso.grpc.service.BlogService;

@RestController
public class WelcomeController {
	
	@Autowired
	BlogService service;

	@GetMapping("/")
	public String greet() {
		return "hello";
	}
	
	@GetMapping("/p")
	public List<Post> getBlog() {
		return service.getAllBlogs();
	}
	
}
