package com.example.codingtest.dto;

import com.example.codingtest.model.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

    private String employNum;
    private String position;
    private String name;

    @Pattern(regexp = "/^\\d{3}-\\d{3,4}-\\d{4}$/")
    private String phonenum;

    @Email
    private String email;

    public EmployeeDto (Employee entity) {
        this.employNum = entity.getEmployNum();
        this.position = entity.getPosition();
        this.name = entity.getName();
        this.phonenum = entity.getPhonenum();
        this.email = entity.getEmail();
    }

    public Employee toEntity () {
        return Employee.builder()
                .position(position)
                .name(name)
                .employNum(employNum)
                .phonenum(phonenum)
                .email(email)
                .build();
    }


}
