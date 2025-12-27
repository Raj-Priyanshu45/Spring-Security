package com.raj.spring_security.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class AppUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message ="Invalid name")
    private String userName;

    private String password;

    public AppUser(String userName , String password){
        this.userName= userName;
        this.password = password;
    }

    public AppUser(){}

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Integer getId(){
        return id;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }
}
