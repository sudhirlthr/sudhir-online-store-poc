package com.zemoso.grpc.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
public class AuthorityJunitTest extends CmsGrpcApplicationTests{

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
	public void testAuthorityShouldNotBeNull(){
		assertNotNull(savedAuthority.getId());
	}
	
	@Test
	public void testAuthorityIdShouldNotBeEqual(){
		Authority authority = new Authority();
		long authorityId = new Random().nextLong();
		authority.setAuthority("ROLE_USER");
		authority.setUsername("dummy@gmail.com"+authorityId);
		authority.setId(authorityId);
		assertFalse(savedAuthority.getId().equals(authority.getId()));
	}
	
	@Test
	public void testAuthorityShouldHaveUninqueUserName(){
		List<Authority> authoties = authRepo.findAll();
		authoties.forEach(authority -> {
			if (authority.getUsername() == null || authority.getUsername().equals(null)) {
				assertFalse(true);
			}
		});
	}
	
	@Test
	public void testAuthorityNameShouldNotBeNull(){
		List<Authority> authoties = authRepo.findAll();
		Set<String> authoritySet = new HashSet<>();
		authoties.forEach(authority -> {
			if (authority.getAuthority() == null ||  authority.getAuthority().equals(null)) {
				assertFalse(true);
			}
		});
	}
	
}
