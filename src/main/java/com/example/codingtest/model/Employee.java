package com.example.codingtest.model;

import com.example.codingtest.dto.EmployeeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String employNum;

    @Column
    private String position;

    @Column
    private String name;

    @Column
    private String phonenum;

    @Column
    private String email;

    @Builder
    public Employee(String employNum, String position, String name, String phonenum, String email) {
        this.employNum = employNum;
        this.position = position;
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }

    public Employee setEntity (EmployeeDto dto) {
        this.employNum = dto.getEmployNum();
        this.position = dto.getPosition();
        this.name = dto.getName();
        this.phonenum = dto.getPhonenum();
        this.email = dto.getEmail();
        return this;
    }


}
