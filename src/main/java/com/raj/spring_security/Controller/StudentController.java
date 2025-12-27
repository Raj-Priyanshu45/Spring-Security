package com.raj.spring_security.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raj.spring_security.Model.StudentResponse;
import com.raj.spring_security.Model.Students;
import com.raj.spring_security.Services.StudentServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class StudentController {

    private final  StudentServices studentServices;
    public StudentController(StudentServices studentServices){
        this.studentServices = studentServices;
    }

    @GetMapping("/students")
    public List<Students> getAllStudents(){
        return studentServices.retAllStudents();
    }

    @GetMapping("csrf-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public ResponseEntity<StudentResponse> createStudents(@Valid @RequestBody StudentResponse studentResponse){

        Students savedStudent = new Students(studentResponse.getName(), studentResponse.getEmail());
        studentServices.createStudents(savedStudent);

        URI location =  ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedStudent.getId())
                        .toUri();
        
        return ResponseEntity.created(location).body(studentResponse);
    }
}
