package com.onlinestore.zemoso.service.user;

import com.onlinestore.zemoso.dto.ApplicationUserDTO;
import com.onlinestore.zemoso.model.ApplicationUser;

import java.util.List;

public interface ApplicationUserService {
    ApplicationUserDTO createApplicationUser(ApplicationUser applicationUser);
    List<ApplicationUserDTO> findAllUser();
    ApplicationUserDTO findByusername(String username);
}
