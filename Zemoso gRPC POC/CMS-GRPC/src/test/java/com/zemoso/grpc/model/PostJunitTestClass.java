package com.zemoso.grpc.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zemoso.grpc.repository.BlogRepository;
import com.zemoso.grpc.repository.SocialusersRepository;
import com.zemoso.grpc.repository.UserRepository;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "/application-test.properties")
public class PostJunitTestClass {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private SocialusersRepository userRepository;
	
	private List<Socialuser> users;
	
	@BeforeEach
	void init() {
		Socialuser socialuser = new Socialuser();
		socialuser.setComments(new ArrayList<Comments>());
		socialuser.setConfirmationToken(UUID.randomUUID().toString());
		socialuser.setEmail("sudhir.kumar@gmail.com");
		socialuser.setEnabled(true);
		socialuser.setFirstName("Sudhir");
		socialuser.setLastName("Kumar");
		socialuser.setPassword("123");
		socialuser.setRefblog(new ArrayList<Post>());
		
		
		this.entityManager.persist(socialuser);
		users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");
	}
	
	@Test
	void testPostJPA() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		
		Post savedPost = blogRepository.save(post);
		assertNotNull(savedPost);
	}
	
	@Test
	void testPostJPAWith_ID() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		
		Post savedPost = blogRepository.save(post);
		assertNotNull(savedPost.getBlogid());
	}
	
	@Test
	void testPostJPAWithHasgCode() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		
		Post savedPost = blogRepository.save(post);
		post.setBlogid(savedPost.getBlogid());
		assertTrue(post.hashCode() == savedPost.hashCode());
	}
	
	@Test
	void testPostJPAWithTitle() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		
		Post savedPost = blogRepository.save(post);
		assertNotNull(savedPost.getTitle());
	}
	
	
	@Test
	void testPostJPAWithNull() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		
		Post savedPost = blogRepository.save(post);
		post.setBlogid(savedPost.getBlogid());
		assertFalse(post.equals(null));
	}
	
	@Test
	void testPostJPAWithCreationdate() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		Post savedPost = blogRepository.save(post);
		assertTrue(savedPost.getCreationdate().equals(post.getCreationdate()));
	}
	
	@Test
	void testPostJPAWithContent() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		Post savedPost = blogRepository.save(post);
		assertTrue(savedPost.getContent().equals(post.getContent()));
	}
	@Test
	void testPostJPAWithCommnets() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		assertTrue(post.getComments().getClass().equals(ArrayList.class));
	}
	@Test
	void testPostJPAWithClassDiff() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		Post savedPost = blogRepository.save(post);
		
		assertFalse(post.equals(new Post()));;
	}
	
	@Test
	void testPostJPAWithCommentNotNull() {
		Post post = new Post();
		post.setTitle("JUnit");
		//post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		Post savedPost = blogRepository.save(post);
		assertNull(savedPost.getComments());
	}
	@Test
	void testPostJPAWith_noUser() {
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		//post.setRefuser(users.get(0));
		Post savedPost = blogRepository.save(post);
		assertNull(savedPost.getRefuser());
	}
}
