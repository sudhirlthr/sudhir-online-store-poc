
package com.zemoso.grpc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.zemoso.grpc.CmsGrpcApplicationTests;
import com.zemoso.grpc.model.Comments;
import com.zemoso.grpc.model.Post;
import com.zemoso.grpc.model.Socialuser;
import com.zemoso.grpc.repository.SocialusersRepository;


@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "/application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringWebTest extends CmsGrpcApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private static String userToken;
	
	@Autowired
	private SocialusersRepository userRepository;

	

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@Order(1)
	public void registerUserGetController() {
		ResultMatcher resultMatcher = MockMvcResultMatchers.view().name("register");
		try {
			mockMvc.perform(get("/register")).andExpect(resultMatcher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(2)
	public void registerUserPostController() {
		try {
			mockMvc.perform(post("/register").param("firstName", "dummyuser First name")
					.param("lastName", "dummyuser lastName").param("email", "dummy@gmail.com"))
					.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Test
	@Order(3)
	public void getRegisterdUser() {
		ResultMatcher resultMatcher = MockMvcResultMatchers.view().name("confirm");
		String token = UUID.randomUUID().toString();
		Socialuser socialuser = new Socialuser();
		socialuser.setEmail("Sudhir@gmail.com");
		socialuser.setConfirmationToken(token);
		socialuser.setComments(new ArrayList<Comments>());
		socialuser.setEnabled(false);
		socialuser.setFirstName("Sudhir");
		socialuser.setLastName("Kumar");
		socialuser.setRefblog(new ArrayList<Post>());
		Socialuser savedUser = userRepository.save(socialuser);
		
		try {
				mockMvc.perform(get("/confirm").queryParam("token", token)).andExpect(resultMatcher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 

	@Test
	@Order(3)
	public void setPaswordForRegisteredUser() {
		ResultMatcher resultMatcher = MockMvcResultMatchers.view().name("confirm");
		String token = UUID.randomUUID().toString();
		Socialuser socialuser = new Socialuser();
		socialuser.setEmail("Sudhir@gmail.com");
		socialuser.setConfirmationToken(token);
		socialuser.setComments(new ArrayList<Comments>());
		socialuser.setEnabled(false);
		socialuser.setFirstName("Sudhir");
		socialuser.setLastName("Kumar");
		socialuser.setRefblog(new ArrayList<Post>());
		Socialuser savedUser = userRepository.save(socialuser);
		
		try {
				mockMvc.perform(post("/confirm").param("password", new Random().longs().toString())).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
}
