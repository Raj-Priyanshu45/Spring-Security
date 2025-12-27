package com.raj.spring_security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    
    @GetMapping("/")
    public String hello() {
        return "Welcome to home page";
    }
    
    @GetMapping("/data")
    public String dataPart(){
        return "This is the private data part";
    }
}
