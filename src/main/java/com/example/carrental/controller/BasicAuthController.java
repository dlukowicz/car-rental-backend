package com.example.carrental.controller;


import com.example.carrental.dto.UserDTO;
import com.example.carrental.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class BasicAuthController {

    private UserService userService;

    public BasicAuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/basicauth")
    public UserDTO basicauth() {
        return userService.getUserLogged();
    }

    @GetMapping(path = "/getUserLogged")
    public UserDTO getUserLogged() {
        return userService.getUserLogged();
    }

}
