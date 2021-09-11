package com.example.carrental.service;

import com.example.carrental.dao.UserRepository;
import com.example.carrental.dto.UserDTO;
import com.example.carrental.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    public UserDTO getUserLogged(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        Long userId = user.isPresent() ? user.get().getUserId() : null;
        return new UserDTO(userId, authentication.getName(), authentication.getAuthorities().toString());
    }

    public boolean isAdmin() {
        return getUserLogged().getRoles().contains("ROLE_ADMIN");
    }

}
