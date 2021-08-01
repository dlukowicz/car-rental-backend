package com.example.carrental.service;

import com.example.carrental.dto.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDTO getUserLogged(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new UserDTO(authentication.getName(), authentication.getAuthorities().toString());
    }

    public boolean isAdmin() {
        return getUserLogged().getRoles().contains("ROLE_ADMIN");
    }

}
