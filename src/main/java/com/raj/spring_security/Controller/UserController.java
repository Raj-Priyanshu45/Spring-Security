package com.raj.spring_security.Controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raj.spring_security.Model.AppUser;
import com.raj.spring_security.Services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
    
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> createUser(@Valid @RequestBody AppUser user){

        AppUser savedUser = userService.registerUser(user);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();
        
        return ResponseEntity.created(location).body(savedUser);
    }

    @PostMapping("/login")
    public String loginPage(@Valid @RequestBody AppUser user){
        return userService.verify(user);
    }
}
