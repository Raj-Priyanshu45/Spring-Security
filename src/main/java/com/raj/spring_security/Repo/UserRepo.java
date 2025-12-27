package com.raj.spring_security.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raj.spring_security.Model.AppUser;
@Repository
public interface UserRepo extends JpaRepository<AppUser, Integer>{
    
    AppUser findByUserName(String username);
}