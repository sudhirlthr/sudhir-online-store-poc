package com.zemoso.grpc.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

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

import com.zemoso.grpc.repository.SocialusersRepository;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "/application-test.properties")
public class SocialUserJunitTestClass {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private SocialusersRepository userRepository;
	
	private boolean equal = true;

	@Test
	void testUserJPA() {
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
		List<Socialuser> users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");
		assertNotEquals(null, users);
		assertNotEquals(null, users.get(0).getUserid());
		
		socialuser.setUserid(users.get(0).getUserid());
		assertTrue(socialuser.equals(users.get(0)));;
	}
	
	
	
	@Test
	void testUserJPAWithNull() {
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
		List<Socialuser> users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");
		
		socialuser.setUserid(users.get(0).getUserid());
		assertFalse(socialuser.equals(null));
	}
	
	@Test
	void testUserJPAWithClassDiff() {
		Socialuser socialuser = new Socialuser();
		socialuser.setComments(new ArrayList<Comments>());
		socialuser.setConfirmationToken(UUID.randomUUID().toString());
		socialuser.setEmail("sudhir.kumar@gmail.com");
		socialuser.setEnabled(true);
		socialuser.setFirstName("Sudhir");
		socialuser.setLastName("Kumar");
		socialuser.setPassword("123");
		socialuser.setRefblog(new ArrayList<Post>());
		
		assertTrue(socialuser.equals(new Socialuser()));;
	}
	
	@Test
	void testUserJPAWithFirstName() {
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
		List<Socialuser> users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");
		
		socialuser.setUserid(users.get(0).getUserid());
		assertTrue(socialuser.getFirstName().equals(users.get(0).getFirstName()));;
	}
	
	@Test
	void testUserJPAWithLastName() {
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
		List<Socialuser> users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");
		
		socialuser.setUserid(users.get(0).getUserid());
		assertEquals(equal, socialuser.getLastName().equals(users.get(0).getLastName()));;
	}
	
	@Test
	void testUserJPAWithHashcode() {
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
		List<Socialuser> users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");
		
		socialuser.setUserid(users.get(0).getUserid());
		assertTrue(socialuser.hashCode() == users.get(0).hashCode());
	}
	
	

	@Test
	void testUserJPAWithConfirmationytoken() {
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
		List<Socialuser> users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");

		socialuser.setUserid(users.get(0).getUserid());
		assertTrue(socialuser.getConfirmationToken().equals(users.get(0).getConfirmationToken()));
		;
	}

	@Test
	void testUserJPAWithEmail() {
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
		List<Socialuser> users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");

		socialuser.setUserid(users.get(0).getUserid());
		assertTrue(socialuser.getEmail().equals(users.get(0).getEmail()));
		;
	}

	@Test
	void testUserEnabled() {
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
		List<Socialuser> users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");

		socialuser.setUserid(users.get(0).getUserid());
		assertTrue(socialuser.isEnabled() == users.get(0).isEnabled());
		;
	}

	@Test
	void testUserId() {
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
		List<Socialuser> users = this.userRepository.findByEmail("sudhir.kumar@gmail.com");

		socialuser.setUserid(users.get(0).getUserid());
		assertTrue(socialuser.getUserid().equals(users.get(0).getUserid()));
		;
	}
	 
}

