package com.example.codingtest.controller;

import com.example.codingtest.dto.EmployeeDto;
import com.example.codingtest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping (value = "/v1/api")

public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(value = "/employee")
    public EmployeeDto saveEmployee (@ModelAttribute EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping (value = "/employee")
    public List<EmployeeDto> listEmployee () {
        return employeeService.getListEmployee();
    }

    @PutMapping (value = "/employee/{employId}")
    public EmployeeDto updateEmployee (
            @PathVariable Long employId,
            @ModelAttribute EmployeeDto employeeDto
    ) {
        return employeeService.updateEmployee(employId, employeeDto);
    }

    @GetMapping(value = "/employee/search/{keyword}")
    public List<EmployeeDto> searchEmpByKeyword (@PathVariable String keyword) {
        return employeeService.findKeyWord(keyword);
    }

    @DeleteMapping (value = "/employee/{employId}")
    public void deleteEmployee (@PathVariable Long employId) {
        employeeService.deleteEmploy(employId);
    }
}
