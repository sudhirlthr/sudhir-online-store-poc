package com.onlinestore.zemoso.service.user;

import com.onlinestore.zemoso.dao.ApplicationUserRepository;
import com.onlinestore.zemoso.model.ApplicationUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository){
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        ApplicationUser user = applicationUserRepository.findByUsername(username);
        return new User(user.getUsername(),user.getPassword(),Collections.emptyList());
    }
}
