package com.raj.spring_security.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Students {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message="Invalid Name")
    private String name;

    @Email
    private String email;

    public Students(String name , String email){
        this.name = name;
        this.email = email;
    }

    public Students(){}

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString(){
        return String.format("Name of the Student is %s /n Email of the studenst is %s", name , email);
    }

}
