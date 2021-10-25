package com.example.codingtest.service;

import com.example.codingtest.dto.EmployeeDto;
import com.example.codingtest.exception.CannotFindEmplException;
import com.example.codingtest.model.Employee;
import com.example.codingtest.repository.EmployeeRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRep employeeRep;

    //직원 등록
    public EmployeeDto saveEmployee (EmployeeDto employeeDto) {
        int check = employeeRep.checkDuplicationId(employeeDto.getEmployNum());
        if (check > 0) {
            throw new RuntimeException();
        }
        Employee employee = employeeDto.toEntity();
        employeeRep.save(employee);

        return employeeDto;
    }

    //직원 리스트
    public List<EmployeeDto> getListEmployee () {
        List<Employee> listEntity = employeeRep.findAll();
        List<EmployeeDto> listDto = employeeRep.findAll().stream().map(EmployeeDto::new).collect(Collectors.toList());
        int size = listDto.size();

        for (int i = 0; i < size; i ++) {
            int id = Integer.valueOf(listEntity.get(i).getEmployNum());
            if (id < 10) {
                listDto.get(i).setEmployNum("00"+listEntity.get(i).getId());
            } else if (id < 100) {
                listDto.get(i).setEmployNum("0"+listEntity.get(i).getId());
            } else {
                listDto.get(i).setEmployNum(""+listEntity.get(i).getId());
            }
        }
        Collections.sort(listDto, new EmployeNameComparator());
        return listDto;
    }

    class EmployeNameComparator implements Comparator<EmployeeDto> {
        @Override
        public int compare(EmployeeDto o1, EmployeeDto o2) {
            return o1.getName().compareTo(o2.getName());
        }

    }
    // 직원 수정
    public EmployeeDto updateEmployee (Long employId, EmployeeDto employeeDto) {
        Employee employee = employeeRep.findById(employId).orElseThrow(CannotFindEmplException::new);
        return new EmployeeDto (employee.setEntity(employeeDto));
    }

    //직원 삭제
    public void deleteEmploy (Long employId) {
        Employee employee = employeeRep.findById(employId).orElseThrow(CannotFindEmplException::new);
        employeeRep.delete(employee);
    }
}
