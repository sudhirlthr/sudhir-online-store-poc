package com.zemoso.grpc.bootstrap;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.zemoso.grpc.model.Post;
import com.zemoso.grpc.model.Comments;
import com.zemoso.grpc.model.Socialuser;
import com.zemoso.grpc.service.BlogService;
import com.zemoso.grpc.service.CommentService;
import com.zemoso.grpc.service.SocialusersService;

@Component
public class CMSBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	SocialusersService usersService;

	@Autowired
	BlogService blogService;

	@Autowired
	CommentService commentsService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}

	private void init() {
		// to keep date format in more readable way

		LocalDate localDate = LocalDate.of(1990, Month.MAY, 20);

		// create user 
		
		Socialuser users = new Socialuser(); List<Comments> comments =
		new ArrayList<>();
		List<Post> blogs = new ArrayList<>();

		users.setFirstName("Sudhir");
		users.setLastName("Kumar");
		users.setEnabled(true);
		users.setEmail("sudhirlthr@gmail.com");
		users.setPassword("123");
		users.setComments(comments);
		users.setRefblog(blogs);
		Socialuser savedUser = usersService.saveUsers(users);

		// User2 
		
		users = new Socialuser(); users.setFirstName("Sergio");
		users.setLastName("Magarati");
		users.setEnabled(true);
		users.setEmail("sergio@zemosolabs.com");
		users.setComments(comments);
		users.setRefblog(blogs);
		Socialuser savedUser2 = usersService.saveUsers(users);
		

		Post blog = new Post();
		blog.setComments(comments);
		blog.setContent("Apple has new Iphone called Iphone SE for mid range device.");
		blog.setRefuser(savedUser);
		blog.setCreationdate(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		blog.setTitle("New Iphone has been launched");
		Post savedBlog = blogService.createBlog(blog);

		// Blog2 
		blog = new Post(); blog.setComments(comments);
		blog.setContent("Number of corona Patients in Maharashtra has crossed 3000");
		blog.setRefuser(savedUser2);
		blog.setCreationdate(LocalDate.of(2020, 03, 15).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		blog.setTitle("Lockdown in India ");
		Post savedBlog2 = blogService.createBlog(blog);
		

		Comments comment = new Comments();
		comment.setContent("Some comment for blog 1");
		comment.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		comment.setRefblog(savedBlog);
		comment.setRefuser(savedUser);
		commentsService.addComments(comment);

		// Comments 2 
		
		comment = new Comments();
		comment.setContent("Some comment for blog 2");
		comment.setCommentsdate(LocalDate.of(2020, 03, 20).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		comment.setRefblog(savedBlog2);
		comment.setRefuser(savedUser);
		commentsService.addComments(comment);

	}
}
