package com.zemoso.grpc.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.zemoso.grpc.repository.CommentsRepository;
import com.zemoso.grpc.repository.SocialusersRepository;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "/application-test.properties")
public class CommentsJUnitTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private SocialusersRepository userRepository;
	
	private List<Socialuser> users;
	private List<Post> posts;
	private Post savedPost;
	
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
		
		Post post = new Post();
		post.setTitle("JUnit");
		post.setComments(new ArrayList<Comments>());
		post.setContent("Junit Test");
		post.setCreationdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		post.setRefuser(users.get(0));
		
		savedPost = blogRepository.save(post);
	}
	
	
	
	@Test
	void testUserComments() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));
		Comments savedComments = commentsRepository.save(userComments);
		assertNotNull(savedComments);
	}
	
	@Test
	void testUserCommentsClassDiff() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		assertNotEquals(new Comments(), savedComments.getClass());
	}

	@Test
	void testUserCommentsWithClass() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(userComments.equals(savedComments));
	}
	 
	@Test
	void testUserCommentsWithHashCode() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(userComments.hashCode() == savedComments.hashCode());
	}
	
	@Test
	void testUserCommentsWithIds() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertNotEquals(null, savedComments.getCommentsid());
	}
	
	@Test
	void testUserCommentsWithContent() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(userComments.getContent().equals(savedComments.getContent()));
	}
	
	@Test
	void testUserCommentsWithCreationDate() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(userComments.getCommentsdate().equals(savedComments.getCommentsdate()));
	}
	
	@Test
	void testUserCommentsWithuserShouldBeNull() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertNotNull(savedComments.getRefuser().getEmail());
	}
	
	@Test
	void testUserCommentsShouldbeMatchBlog() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(savedComments.getRefuser().equals(users.get(0)));
	}
	
	@Test
	void testUserCommentsShouldbeMatchOneOFUser() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(savedComments.getRefuser().equals(users.get(0)));
	}
	
	@Test
	void testUserCommentsShouldbeMatchWithId() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(savedComments.getCommentsid().equals(userComments.getCommentsid()));
	}
	
	@Test
	void testUserCommentsShouldbeMatchContent() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(savedComments.getContent().equals(userComments.getContent()));
	}
	@Test
	void testUserCommentsShouldbeMatchContentDate() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(savedComments.getCommentsdate().equals(userComments.getCommentsdate()));
	}
	
	@Test
	void testUserCommentsShouldbeMatchWithBlog() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(savedComments.getRefblog().equals(savedPost));
	}
	@Test
	void testUserCommentsShouldbeMatchWithBlogId() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(savedComments.getRefblog().getBlogid().equals(savedPost.getBlogid()));
	}
	
	@Test
	void testUserCommentsShouldbeEnabledUsers() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertTrue(savedComments.getRefuser().isEnabled() == users.get(0).isEnabled());
	}
	
	@Test
	void testUserCommentsShouldbeUsers() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertFalse(savedComments.getRefuser().getRefblog().equals(savedPost));
	}
	
	@Test
	void testUserCommentsShouldNotMatchDisabledUser() {
		Comments userComments = new Comments();
		userComments.setCommentsdate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		userComments.setContent("Comment on Junit test");
		userComments.setRefblog(savedPost);
		userComments.setRefuser(users.get(0));

		Comments savedComments = commentsRepository.save(userComments);
		userComments.setCommentsid(savedComments.getCommentsid());
		assertFalse(savedComments.getRefuser().equals(new Users()));
	}
	
}
