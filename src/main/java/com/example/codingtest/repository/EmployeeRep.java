package com.example.codingtest.repository;

import com.example.codingtest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface EmployeeRep extends JpaRepository< Employee, Long> {

    @Query ("select count (*) from Employee e where e.employNum = :id")
    int checkDuplicationId (@Param("id") String id);

    Optional<Employee> findById (String imployId);

    Optional<Employee> findByEmail (String email);

}
