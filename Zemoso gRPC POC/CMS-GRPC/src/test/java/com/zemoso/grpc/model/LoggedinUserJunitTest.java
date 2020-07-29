package com.zemoso.grpc.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.tomcat.jni.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zemoso.grpc.CmsGrpcApplicationTests;
import com.zemoso.grpc.repository.AuhtorityRepository;
import com.zemoso.grpc.repository.UserRepository;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "/application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoggedinUserJunitTest extends CmsGrpcApplicationTests{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuhtorityRepository authRepo;
	
	private Authority savedAuthority;
	
	private List<Users> users;
	
	private Set<Authority> authoritySet;
	
	@BeforeEach
	void init() {	
		Users user = new Users();
		Authority authority = new Authority();
		long nextLong = new Random().nextLong();
		authority.setId(new Random().nextLong());
		authority.setAuthority("ROLE_USER");
		authority.setUsername("dummy@gmail.com"+nextLong);
		authoritySet = new HashSet<Authority>();
		authoritySet.add(authority);
		
		user.setEnabled(true);
		user.setId(new Random().nextLong());
		user.setPassword("123");
		user.setUsername("dummy@gmail.com"+nextLong);
		user.setAuthority(authoritySet);
		Users saveduser = userRepository.save(user);
		savedAuthority = authRepo.save(authority);
		
		users = this.userRepository.findByUsername("dummy@gmail.com"+nextLong);
	}
	
	@Test
	public void userShouldNotNull() {
		assertNotNull(users);
	}
	
	@Test
	public void userNameShouldNotNull() {
		assertNotNull(users.get(0).getUsername());
	}
	
	@Test
	public void userPasswordShouldNotNull() {
		assertNotNull(users.get(0).getPassword());
	}
	
	@Test
	public void userShouldBeEnabled_true() {
		assertTrue(users.get(0).getEnabled());
	}
	
	@Test
	public void userAuthorityShouldNotNull() {
		assertNotNull(users.get(0).getAuthority());
	}
	
	@Test
	public void usersAndAuthorityEntitytest () {
		assertNotNull(users.get(0).getAuthority().getClass().equals(Authority.class));
	}
	
	@Test
	public void userAuthirityClassDiff() {
		assertFalse(users.get(0).getAuthority().getClass().equals(new Authority()));
	}
	@Test
	public void userAuthirityClass() {
		assertFalse(users.get(0).getAuthority().toArray()[0].equals(savedAuthority));
	}
	
	@Test
	public void testUserName() {
		assertTrue(users.get(0).getUsername().equals(savedAuthority.getUsername()));
	}
	
	
	//username should not be same
	@Test
	public void testUserNameShouldBeUnique() {
		Users user = new Users();
		Authority authority = new Authority();
		long nextLong = new Random().nextLong();
		authority.setId(new Random().nextLong());
		authority.setAuthority("ROLE_USER");
		authority.setUsername("dummy@gmail.com"+nextLong);
		authoritySet = new HashSet<Authority>();
		authoritySet.add(authority);
		
		user.setEnabled(true);
		user.setId(new Random().nextLong());
		user.setPassword("123");
		user.setUsername("dummy@gmail.com"+nextLong);
		user.setAuthority(authoritySet);
		Users newUser = userRepository.save(user);
		
		assertFalse(users.get(0).getUsername().equals(newUser.getUsername()));
	}
	
	//username should not be same
	@Test
	public void testUserId() {
		Users user = new Users();
		Authority authority = new Authority();
		long nextLong = new Random().nextLong();
		authority.setId(new Random().nextLong());
		authority.setAuthority("ROLE_USER");
		authority.setUsername("dummy@gmail.com"+nextLong);
		authoritySet = new HashSet<Authority>();
		authoritySet.add(authority);
		
		user.setEnabled(true);
		user.setId(new Random().nextLong());
		user.setPassword("123");
		user.setUsername("dummy@gmail.com"+nextLong);
		user.setAuthority(authoritySet);
		Users newUser = userRepository.save(user);
		
		assertFalse(users.get(0).getId().equals(newUser.getId()));
	}
	
	@Test
	public void testUserAuthoritSet() {
		Users user = new Users();
		Authority authority = new Authority();
		long nextLong = new Random().nextLong();
		authority.setId(new Random().nextLong());
		authority.setAuthority("ROLE_USER");
		authority.setUsername("dummy@gmail.com"+nextLong);
		authoritySet = new HashSet<Authority>();
		authoritySet.add(authority);
		
		user.setEnabled(true);
		user.setId(new Random().nextLong());
		user.setPassword("123");
		user.setUsername("dummy@gmail.com"+nextLong);
		user.setAuthority(authoritySet);
		Users newUser = userRepository.save(user);
		
		assertFalse(users.get(0).getAuthority().equals(new HashSet<Authority>()));
	}
	
	@Test
	public void testUserDiff() {
		Users user = new Users();
		Authority authority = new Authority();
		long nextLong = new Random().nextLong();
		authority.setId(new Random().nextLong());
		authority.setAuthority("ROLE_USER");
		authority.setUsername("dummy@gmail.com"+nextLong);
		authoritySet = new HashSet<Authority>();
		authoritySet.add(authority);
		
		user.setEnabled(true);
		user.setId(new Random().nextLong());
		user.setPassword("123");
		user.setUsername("dummy@gmail.com"+nextLong);
		user.setAuthority(authoritySet);
		Users newUser = userRepository.save(user);
		
		assertFalse(users.get(0).equals(new Users()));
	}
	
	@Test
	public void testUserPassword() {
		Users user = new Users();
		Authority authority = new Authority();
		long nextLong = new Random().nextLong();
		authority.setId(new Random().nextLong());
		authority.setAuthority("ROLE_USER");
		authority.setUsername("dummy@gmail.com"+nextLong);
		authoritySet = new HashSet<Authority>();
		authoritySet.add(authority);
		
		user.setEnabled(true);
		user.setId(new Random().nextLong());
		user.setPassword("123");
		user.setUsername("dummy@gmail.com"+nextLong);
		user.setAuthority(authoritySet);
		Users newUser = userRepository.save(user);
		
		assertFalse(users.get(0).getPassword().equals(new Users().getPassword()));
	}
	
	@Test
	public void testUserEnabled() {
		Users user = new Users();
		Authority authority = new Authority();
		long nextLong = new Random().nextLong();
		authority.setId(new Random().nextLong());
		authority.setAuthority("ROLE_USER"+nextLong);
		authority.setUsername("dummy@gmail.com"+nextLong);
		authoritySet = new HashSet<Authority>();
		authoritySet.add(authority);
		
		user.setEnabled(true);
		user.setId(new Random().nextLong());
		user.setPassword("123");
		user.setUsername("dummy@gmail.com"+nextLong);
		user.setAuthority(authoritySet);
		Users newUser = userRepository.save(user);
		
		assertFalse(users.get(0).getEnabled() == new Users().getEnabled() || users.get(0).getEnabled().equals(new Users().getEnabled()));
	}
}
