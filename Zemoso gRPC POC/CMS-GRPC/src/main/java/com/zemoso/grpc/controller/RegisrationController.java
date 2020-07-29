/**
 * 
 */
package com.zemoso.grpc.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.zemoso.grpc.model.Authority;
import com.zemoso.grpc.model.Socialuser;
import com.zemoso.grpc.model.Users;
import com.zemoso.grpc.service.AuthorityService;
import com.zemoso.grpc.service.EmailService;
import com.zemoso.grpc.service.SocialusersService;
import com.zemoso.grpc.service.UsersService;

/**
 * @author sudhirk
 *
 */
@RestController
public class RegisrationController {
	
	@Autowired
	SocialusersService socialuserService;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	AuthorityService authorityService;
	
	
	/* @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder; */
	 
	
	
	@Autowired private EmailService emailService;
	 
	

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage(ModelAndView modelAndView, Socialuser user){
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	// Process form input data
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid Socialuser user, BindingResult bindingResult, HttpServletRequest request) {
				
		// Lookup user in database by e-mail
		Socialuser userExists = socialuserService.getUserByEmail(user.getEmail());
		
		System.out.println(userExists);
		
		if (userExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("register");
			bindingResult.reject("email");
		}
			
		if (bindingResult.hasErrors()) { 
			modelAndView.setViewName("register");		
		} else { // new user so we create user and send confirmation e-mail
					
			
			  // Disable user until they click on confirmation link in email
			  user.setEnabled(false);
			  
			  // Generate random 36-character string token for confirmation link
			  user.setConfirmationToken(UUID.randomUUID().toString());
			 
		        
			  Socialuser savedUser = socialuserService.saveUsers(user);
		    System.out.println("User saved with email : "+savedUser.getEmail());
				
			String appUrl = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort();
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(user.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
					+ appUrl + "/confirm?token=" + user.getConfirmationToken());
			registrationEmail.setFrom("noreply@domain.com");
			
			emailService.sendEmail(registrationEmail);
			
			modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
			modelAndView.setViewName("register");
		}
			
		return modelAndView;
	}
	
	// Process confirmation link
	@RequestMapping(value="/confirm", method = RequestMethod.GET)
	public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
			
		Socialuser user = socialuserService.getUserByConfirmationToken(token);
			
		if (user == null) { // No token found in DB
			modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
		} else { // Token found
			modelAndView.addObject("confirmationToken", user.getConfirmationToken());
		}
			
		modelAndView.setViewName("confirm");
		return modelAndView;		
	}
	
	// Process confirmation link
	@RequestMapping(value="/confirm", method = RequestMethod.POST)
	public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams, RedirectAttributes redir) {
				
		modelAndView.setViewName("confirm");
		
		Zxcvbn passwordCheck = new Zxcvbn();
		
		Strength strength = passwordCheck.measure((String) requestParams.get("password"));
		
		if (strength.getScore() < 3) {
			bindingResult.reject("password");
			
			redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

			modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
			System.out.println(requestParams.get("token"));
			return modelAndView;
		}
	
		// Find the user associated with the reset token
		Socialuser socialuser = socialuserService.getUserByConfirmationToken((String) requestParams.get("token"));

		// Set new password
		//customer.setPassword(bCryptPasswordEncoder.encode((CharSequence) requestParams.get("password")));
		socialuser.setPassword((String) requestParams.get("password"));

		// Set user to enabled
		socialuser.setEnabled(true);
		
		// Save user
		socialuserService.saveUsers(socialuser);
		
		// save current customer as a User
		Users users = new Users();
		Set<Authority> userAuthoritySet = new HashSet<>();
		Authority userAuthority = new Authority();
		
		userAuthority.setAuthority("ROLE_USER");// will be set as customer-type
		userAuthority.setUsername(socialuser.getEmail());
		
		userAuthoritySet.add(userAuthority);
		
		
		users.setUsername(socialuser.getEmail());
		users.setPassword("{noop}"+socialuser.getPassword());
		users.setEnabled(true);
		
		//users.setId(usersService.getNextId());
		
		//userAuthority.setId(users.getId());
		
		//users.setAuthority(userAuthoritySet);
		
		usersService.saveUser(users);
		authorityService.saveAuthority(userAuthority);
		
		
		
		
		
		
		
		modelAndView.addObject("successMessage", "Your password has been set!");
		return modelAndView;		
	}
}
