package com.example.carrental.service;

import com.example.carrental.dao.UserRepository;
import com.example.carrental.model.Role;
import com.example.carrental.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private UserRepository userRepository;


    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(userName);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();

            List<String> roleList = new ArrayList<>();
            for(Role role: user.getRoles()) {
                roleList.add(role.getRoleName());
            }

            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password( bCryptPasswordEncoder.encode(user.getPassword()) )
                    .roles(roleList.toArray(new String[0]))
                    .build();

           return userDetails;
        } else {
            throw new UsernameNotFoundException("User Name is not Found");
        }
    }
}
