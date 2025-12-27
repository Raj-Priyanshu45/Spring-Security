package com.raj.spring_security.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raj.spring_security.Model.Students;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer>{
    
}
