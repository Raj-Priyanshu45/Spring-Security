package com.raj.spring_security.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.raj.spring_security.Model.AppUser;
import com.raj.spring_security.Model.UserPrincipal;
import com.raj.spring_security.Repo.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;
    public MyUserDetailsService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = userRepo.findByUserName(username);

        if(user == null){
            System.out.print("UserName not found");
            throw new UsernameNotFoundException("Username not there");
        }

        return new UserPrincipal(user);
    }
}
