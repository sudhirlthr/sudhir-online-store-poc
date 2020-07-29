package com.onlinestore.zemoso.service.user;

import com.onlinestore.zemoso.dao.ApplicationUserRepository;
import com.onlinestore.zemoso.dto.ApplicationUserDTO;
import com.onlinestore.zemoso.exception.UserNotFoundException;
import com.onlinestore.zemoso.model.ApplicationUser;
import com.onlinestore.zemoso.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService{

    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository){
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public ApplicationUserDTO createApplicationUser(ApplicationUser applicationUser) {
        applicationUser = applicationUserRepository.save(applicationUser);
        return ObjectMapperUtil.map(applicationUser, ApplicationUserDTO.class);
    }

    @Override
    public List<ApplicationUserDTO> findAllUser() {
        List<ApplicationUser> applicationUsers = applicationUserRepository.findAll();
        return applicationUsers.stream()
                .map(entity -> ObjectMapperUtil.map(entity, ApplicationUserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationUserDTO findByusername(String username) {
            ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
            if (applicationUser == null) throw new UserNotFoundException(username);
            return ObjectMapperUtil.map(applicationUser, ApplicationUserDTO.class);
    }
}
