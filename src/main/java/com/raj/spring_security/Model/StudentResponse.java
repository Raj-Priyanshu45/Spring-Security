package com.raj.spring_security.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class StudentResponse {
    @NotNull(message="Invlalid Name")
    private String name;
    @Email
    private String email;

    public StudentResponse(String name , String email){
        this.name = name;
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}
