package com.raj.spring_security.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raj.spring_security.Model.Students;
import com.raj.spring_security.Repo.StudentsRepo;

@Service
public class StudentServices {
    
    private final StudentsRepo studentsRepo;
    public StudentServices(StudentsRepo studentsRepo){
        this.studentsRepo = studentsRepo;
    }

    public Students createStudents(Students students){
        return studentsRepo.save(students);
    }

    public List<Students> retAllStudents(){
        return studentsRepo.findAll();
    }
}
