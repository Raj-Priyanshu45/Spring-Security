package com.raj.spring_security.Services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.raj.spring_security.Model.AppUser;
import com.raj.spring_security.Repo.UserRepo;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTServices jwtServices;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder , AuthenticationManager authenticationManager,JWTServices jwtServices) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtServices = jwtServices;
    }

    public AppUser registerUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(AppUser user){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            user.getUserName() , user.getPassword()
        ));

        if(authentication.isAuthenticated()){
            return jwtServices.generateToken(user.getUserName());
        }

        return "Login failed";
    }
}

